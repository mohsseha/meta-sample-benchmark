# FAQ: ChBird + Meta Spatial SDK Benchmark

## 1. What exactly are we testing?
Whether AI agents produce better code when they have ChBird's Deep Code Indexing (via MCP Q&A) versus raw documentation access.

## 2. Why Meta Spatial SDK specifically?
Complex documentation + existing sample apps = perfect testbed. We can compare agent output against known-good implementations.

## 3. What's different between Agent A and Agent B?
- **Agent A**: Gets task ticket + `Meta-spatial-sdk-docs` repo as a child directory (must search/parse files inline)
- **Agent B**: Gets same ticket + same docs repo + ChBird MCP server (can ask questions, get grounded answers)

## 4. Why not just give Agent A no documentation?
That would be unfair. We're proving ChBird's **indexing lift**, not just "docs vs no docs."

## 5. What is ChBird actually indexing?
Only the Meta Spatial SDK v0.8.0 **documentation** (from `Meta-spatial-sdk-docs` repo). NOT the sample apps themselves.

## 6. Why use sample apps as the test if we're not indexing them?
Sample apps are the **target output** (ground truth), not the input. Agents try to recreate them using only the ticket + documentation.

**Phase 1 (Manual):** We manually verify one sample app output from both agents.

**Future Automation:** A "Judge Agent" will compare Agent A and Agent B outputs against the GitHub sample apps and grade them systematically.

## 7. What does "Deep Code Indexing via MCP" mean in practice?
ChBird exposes a question-answering system through Model Context Protocol. Agent B can ask "How do I play an animation clip in SDK v0.8.0?" and get accurate answers. Agent A must grep/search docs manually.

## 8. What's the success criteria?
**Phase 1:** Agent B produces higher quality code than Agent A for a single sample app (manual assessment).

**Future Phases:** Agent B closes more tickets successfully with less supervision and fewer iterations than Agent A, producing code that compiles, runs, and matches SDK patterns better (automated grading via Judge Agent).
