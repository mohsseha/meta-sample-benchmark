#!/bin/bash

set -e # Exit immediately if a command exits with a non-zero status.

# Make sure we're in a directory with subdirectories.
if ! ls -d */ > /dev/null 2>&1; then
    echo "This doesn't look right. No subdirectories found."
    echo "Run this from your 'GeneratedSamples' directory."
    exit 1
fi

GEMINI_HOME="$HOME/.gemini"
SDK_DOCS_PATH="/home/husainal-mohssen/src/Meta-spatial-sdk-docs/"
GEMINI_PROMPT="Examine the TICKET.md file. Implement its requirements incurrent folder. The source TICKET.md file MUST NOT be modified or deleted."

for dir in */; do
    # Enter the sample directory. The trailing slash in '*/' ensures we only get directories.
    cd "$dir"
    echo "----------------------------------------------------"
    echo "Processing directory: $dir"
    echo "----------------------------------------------------"

    # Delete everything except TICKET.md. Simple and effective.
    # -mindepth prevents it from deleting the current directory '.'.
    find . -mindepth 1 ! -name TICKET.md -delete
    echo "Cleaned directory, only TICKET.md remains."

    # --- MCP RUN ---
    echo "[MCP] Configuring environment..."
    cp "${GEMINI_HOME}/GEMINI.md.MCP" "${GEMINI_HOME}/GEMINI.md"
    cp "${GEMINI_HOME}/settings.json.MCP" "${GEMINI_HOME}/settings.json"

    mkdir MCP
    cp TICKET.md MCP/
    cd MCP

    echo "[MCP] Running gemini in $(pwd)..."
    date
    timeout 20m gemini --yolo --include-directories . --include-directories "$SDK_DOCS_PATH" --prompt "$GEMINI_PROMPT"
    cd ..
    echo "[MCP] Finished run for $dir"
    date


    # --- NO_MCP RUN ---
    echo "[NO_MCP] Configuring environment..."
    cp "${GEMINI_HOME}/GEMINI.md.NO_MCP" "${GEMINI_HOME}/GEMINI.md"
    cp "${GEMINI_HOME}/settings.json.NO_MCP" "${GEMINI_HOME}/settings.json"

    mkdir NO_MCP
    cp TICKET.md NO_MCP/
    cd NO_MCP

    date
    echo "[NO_MCP] Running gemini in $(pwd)..."
    timeout 20m gemini --yolo --include-directories . --include-directories "$SDK_DOCS_PATH" --prompt "$GEMINI_PROMPT"
    cd ..
    echo "[NO_MCP] Finished run for $dir"
    date


    # Go back to the root 'GeneratedSamples' to process the next directory.
    cd ..
done

echo "----------------------------------------------------"
echo "All directories processed. Job done."
echo "----------------------------------------------------"
