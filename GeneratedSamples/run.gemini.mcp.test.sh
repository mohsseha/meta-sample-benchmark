#!/bin/bash
set -e

MCP_ONLY=0
if [[ "$1" == "--mcp-only" ]]; then
    MCP_ONLY=1
    echo "Running in MCP-only mode."
fi

GEMINI_HOME="$HOME/.gemini"
SDK_DOCS_PATH="/home/husainal-mohssen/src/Meta-spatial-sdk-docs/"
GEMINI_PROMPT="Examine the TICKET.md file. Implement its requirements incurrent folder. The source TICKET.md file MUST NOT be modified or deleted."

for dir in */; do
    cd "$dir"
    echo "----------------------------------------------------"
    echo "Processing directory: $dir"
    echo "----------------------------------------------------"

    # Correct, simple, and robust cleanup.
    # Loop through all top-level items in the current directory.
    for item in *; do
        if [ "$item" != "TICKET.md" ]; then
            # rm is the right tool for this job.
            rm -rf "$item"
        fi
    done
    echo "Cleaned directory, only TICKET.md remains."

    # --- MCP RUN ---
    echo "[MCP] Configuring environment..."
    cp "${GEMINI_HOME}/GEMINI.md.MCP" "${GEMINI_HOME}/GEMINI.md"
    cp "${GEMINI_HOME}/settings.json.MCP" "${GEMINI_HOME}/settings.json"

    mkdir MCP
    cp TICKET.md MCP/
    cd MCP

    echo "[MCP] Running gemini in $(pwd)..."
    timeout 35m gemini --yolo --include-directories . --include-directories "$SDK_DOCS_PATH" --prompt "$GEMINI_PROMPT"
    cd ..

    if [ "$MCP_ONLY" -eq 0 ]; then
        # --- NO_MCP RUN ---
        echo "[NO_MCP] Configuring environment..."
        cp "${GEMINI_HOME}/GEMINI.md.NO_MCP" "${GEMINI_HOME}/GEMINI.md"
        cp "${GEMINI_HOME}/settings.json.NO_MCP" "${GEMINI_HOME}/settings.json"

        mkdir NO_MCP
        cp TICKET.md NO_MCP/
        cd NO_MCP

        echo "[NO_MCP] Running gemini in $(pwd)..."
        timeout 35m gemini --yolo --include-directories . --include-directories "$SDK_DOCS_PATH" --prompt "$GEMINI_PROMPT"
        cd ..
    fi

    cd ..
done

echo "----------------------------------------------------"
echo "All directories processed. Job done."
echo "----------------------------------------------------"
