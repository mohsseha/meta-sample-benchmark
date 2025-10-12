#!/bin/bash

# A simple, robust script for batch-grading AI code samples.
# Creates a persistent, auditable workspace for each sample run.

# --- Configuration ---
readonly GENERATED_SAMPLES_DIR="GeneratedSamples"
readonly REFERENCE_SAMPLES_DIR="Meta-Spatial-SDK-Samples"
readonly WORKING_DIR="grader_agent_working_dir"
readonly JUDGEMENTS_DIR="judgements"
readonly PROMPT_FILE="grader_agent_prompt.md"
readonly AGENT_TIMEOUT="20m"

# --- Script Health ---
# Fail on unset variables or pipe failures. We don't use -e so the loop continues on error.
set -uo pipefail

# --- Pre-flight Checks ---
if [ ! -f "${PROMPT_FILE}" ]; then echo "❌ Error: Prompt file not found: '${PROMPT_FILE}'" >&2; exit 1; fi
if [ ! -d "${GENERATED_SAMPLES_DIR}" ]; then echo "❌ Error: Samples directory not found: '${GENERATED_SAMPLES_DIR}'" >&2; exit 1; fi
if [ ! -d "${REFERENCE_SAMPLES_DIR}" ]; then echo "❌ Error: Reference directory not found: '${REFERENCE_SAMPLES_DIR}'" >&2; exit 1; fi

# --- One-Time Setup ---
echo "🔥 WARNING: Nuking all previous content in './${WORKING_DIR}'."
rm -rf "${WORKING_DIR}"
mkdir -p "${WORKING_DIR}"
mkdir -p "${JUDGEMENTS_DIR}"

# --- Load the Prompt ---
# The prompt file is now assumed to be complete and correct.
readonly GRADER_PROMPT=$(<"${PROMPT_FILE}")

# --- Main Processing Loop ---
echo "🚀 Starting batch grading process..."

for sample_path in "${GENERATED_SAMPLES_DIR}"/*; do
    if [ ! -d "${sample_path}" ]; then
        continue
    fi

    sample_name=$(basename "${sample_path}")
    echo "----------------------------------------------------"
    echo "▶️  Processing Sample: ${sample_name}"

    # Each sample gets a persistent subdirectory in the working area.
    sample_work_dir="${WORKING_DIR}/${sample_name}"
    mkdir -p "${sample_work_dir}"

    # 1. Validate inputs for this specific sample.
    mcp_path="${sample_path}/MCP"
    no_mcp_path="${sample_path}/NO_MCP"
    ref_path="${REFERENCE_SAMPLES_DIR}/${sample_name}"

    if [ ! -d "${mcp_path}" ] || [ ! -d "${no_mcp_path}" ] || [ ! -d "${ref_path}" ]; then
        echo "⚠️  Skipping: Incomplete sample. Missing MCP, NO_MCP, or REF directory." >&2
        continue
    fi

    # 2. Assemble the context for the agent in its dedicated directory.
    echo "--> Assembling context in '${sample_work_dir}'..."
    cp -R "${sample_path}/." "${sample_work_dir}/"
    cp -R "${ref_path}" "${sample_work_dir}/REF"

    # 3. Execute agent, capturing all output to a log file for debugging.
    echo "--> Invoking agent. Full log: '${sample_work_dir}/agent_run.log'"
    (
        cd "${sample_work_dir}"
        # The '&>' redirects both stdout and stderr to the log file.
        timeout "${AGENT_TIMEOUT}" gemini --prompt "$GRADER_PROMPT" &> agent_run.log
    ) || true # Continue the loop even if the agent command fails or times out.

    # 4. Check for the agent-generated result and archive it.
    result_file="${sample_work_dir}/grading_results.json"
    archive_path="${JUDGEMENTS_DIR}/${sample_name}.json"

    if [ -f "${result_file}" ]; then
        echo "✅ Success: Agent produced results. Archiving to '${archive_path}'."
        mv "${result_file}" "${archive_path}"
    else
        echo "❌ Failure: Agent did not produce 'grading_results.json'." >&2
        echo "   Check the log for details: '${sample_work_dir}/agent_run.log'"
    fi
done

echo "----------------------------------------------------"
echo "🎉 Batch grading complete."
echo "   Successful judgements are in '${JUDGEMENTS_DIR}'."
echo "   Detailed logs for every run are in '${WORKING_DIR}/[SampleName]/'."
