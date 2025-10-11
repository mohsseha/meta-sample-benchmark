# Meta Spatial SDK AI Agent Benchmark

This repository contains a benchmark designed to evaluate the performance of AI agents generating Android applications against the **Meta Spatial SDK v0.8.0**. The experiment was conducted using **Gemini Pro v0.8.2**.

The primary goal is to quantify the impact of providing agents with specialized, RAG-based documentation access on the quality and correctness of the generated code.

## Benchmark Methodology

The benchmark is based on a "clean room" implementation process for 12 different sample applications. For each sample, an agent is given a `TICKET.md` file outlining high-level requirements and must generate a complete Android application from scratch.

We compare three distinct versions for each sample:

1.  **Reference Implementation**: The official, human-written sample code. This serves as the ground truth for functionality.
2.  **MCP_ENABLED**: AI-generated code from an agent that **has access** to a specialized tool for querying the Meta Spatial SDK documentation.
3.  **MCP_DISABLED**: AI-generated code from an agent that **does not have access** to the specialized documentation tool.

## Evaluation

The quality of the two AI-generated implementations is assessed by a third "grader" AI agent. This agent performs a static analysis of the codebases, using the detailed rubric found in `grader_agent_prompt.md`. The final output is a `grading_results.json` file containing structured scores and justifications, allowing for objective, data-driven comparison of the two agent configurations.

## Getting Started

The reference implementations are included as a git submodule. To clone this repository and pull the necessary reference code, use the following commands:

```sh
# Clone this repository
git clone <repo_url>
cd meta-sample-benchmark

# Initialize the submodule to pull the reference samples
git submodule update --init --recursive
```