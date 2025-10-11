#!/bin/bash

# Rigorous script to automate the batch grading of AI-generated code samples.
# It assembles a clean context for the grading agent, invokes it, and archives the results.

# --- Configuration ---
readonly GENERATED_SAMPLES_DIR="GeneratedSamples"
readonly REFERENCE_SAMPLES_DIR="Meta-Spatial-SDK-Samples"
readonly WORKING_DIR="grader_agent_working_dir"
readonly JUDGEMENTS_DIR="judgements"
readonly PROMPT_FILE="grader_agent_prompt.md"
readonly AGENT_TIMEOUT="20m"

# --- Script Health ---
# Exit immediately if a command exits with a non-zero status.
# Treat unset variables as an error.
# Pipelines fail if any command fails, not just the last one.
set -euo pipefail

# --- Pre-flight Checks & Setup ---
if [ ! -f "${PROMPT_FILE}" ]; then
    echo "❌ Error: Prompt file not found at '${PROMPT_FILE}'" >&2
    exit 1
fi
if [ ! -d "${GENERATED_SAMPLES_DIR}" ]; then
    echo "❌ Error: Generated samples directory not found at '${GENERATED_SAMPLES_DIR}'" >&2
    exit 1
fi
if [ ! -d "${REFERENCE_SAMPLES_DIR}" ]; then
    echo "❌ Error: Reference samples directory not found at '${REFERENCE_SAMPLES_DIR}'" >&2
    exit 1
fi

echo "🚀 Starting batch grading process..."
echo "--> Ensuring output directory exists at '${JUDGEMENTS_DIR}'"
mkdir -p "${JUDGEMENTS_DIR}"

# --- Main Processing Loop ---
# Load the prompt once. No need to read it in every loop.
readonly GEMINI_PROMPT=$(<"${PROMPT_FILE}")

for sample_path in "${GENERATED_SAMPLES_DIR}"/*; do
    # Ensure we are only processing directories
    if [ ! -d "${sample_path}" ]; then
        continue
    fi

    local sample_name
    sample_name=$(basename "${sample_path}")
    echo "----------------------------------------------------"
    echo "▶️  Processing Sample: ${sample_name}"

    # 1. Validate all required components for the current sample
    local mcp_path="${sample_path}/MCP"
    local no_mcp_path="${sample_path}/NO_MCP"
    local ref_path="${REFERENCE_SAMPLES_DIR}/${sample_name}"

    if [ ! -d "${mcp_path}" ] || [ ! -d "${no_mcp_path}" ] || [ ! -d "${ref_path}" ]; then
        echo "⚠️  Skipping: Incomplete sample. Missing one or more required directories:" >&2
        [ ! -d "${mcp_path}" ] && echo "    - MCP directory" >&2
        [ ! -d "${no_mcp_path}" ] && echo "    - NO_MCP directory" >&2
        [ ! -d "${ref_path}" ] && echo "    - Reference implementation" >&2
        continue
    fi

    # 2. Assemble the clean, unified environment for the agent
    echo "--> Assembling clean environment in '${WORKING_DIR}'..."
    rm -rf "${WORKING_DIR}"
    mkdir -p "${WORKING_DIR}"
    
    # Copy generated code and the ticket
    cp -R "${sample_path}/." "${WORKING_DIR}/"
    # Copy reference implementation, renaming it to REF as the prompt expects
    cp -R "${ref_path}" "${WORKING_DIR}/REF"

    # 3. Execute the agent within the isolated environment
    echo "--> Invoking grading agent..."
    # We use a subshell for the cd to keep the main script's CWD clean.
    (
        cd "${WORKING_DIR}"
        timeout "${AGENT_TIMEOUT}" gemini --prompt "$GEMINI_PROMPT"
    )

    # 4. Verify and Archive the results
    local result_file="${WORKING_DIR}/grading_results.json"
    local archive_path="${JUDGEMENTS_DIR}/${sample_name}.json"

    if [ -f "${result_file}" ]; then
        echo "✅ Success: Agent produced results. Archiving to '${archive_path}'."
        mv "${result_file}" "${archive_path}"
    else
        echo "❌ Failure: Agent did not produce 'grading_results.json' for '${sample_name}'." >&2
    fi
done

echo "----------------------------------------------------"
echo "🎉 Batch grading complete. All results are in the '${JUDGEMENTS_DIR}' directory."
