# Project context

This repository is a starter template for a greenfield Java project used in an introductory software engineering course in an undergraduate computer science program. Students use it as the starting point for their own projects.

# Default user context

Unless the user says otherwise, assume that you are assisting a student working on a project in this repository. If the user identifies themselves as an instructor or another project stakeholder, adapt your response to that role.

# Student profile

* Prior knowledge: Basic Java and OOP concepts.
* Level of programming experience: Beginner
* IDE and level of expertise: IntelliJ - Beginner

# Guidance for interacting with users

* Explain the rationale for significant actions: what you did and why.
* Keep explanations brief but instructive, supporting learning through responsible use of AI. For example:

  * When suggesting a Git command, briefly explain what it does.
  * Add explanatory Javadoc comments to all classes and to nontrivial methods and fields when their purpose or behavior is not obvious.
  * Make generated code as self-explanatory as possible, and include explanatory comments where they improve understanding.
  * When faced with a design choice, choose the simplest option that is sufficient for the requirements, while briefly explaining relevant more advanced alternatives.

# Project-specific requirements

## Java version:

Ensure that Java 25 is used when running the application or build tasks. On macOS, use `sdk use java 25.0.3.fx-zulu` to switch to Java 25 if needed.

## Git

Use lightweight tags unless the user requests an annotated tag.
When proposing or creating a commit message, include enough detail to explain the rationale for the change.
Do not commit or push unless explicitly asked.

## Testing

After making any code changes to the application (especially to Gunna.java or task-related classes):

1. **Update test plan**: Review and update `test/ui-test-plan.md` if the code changes affect user-facing behavior or add new features. Add new test cases for new functionality or modify existing ones if behavior changed.

2. **Run UI tests**: Execute the test-ui skill by running:
   ```bash
   python3 .claude/skills/test-ui/scripts/run-ui-tests.py
   ```

3. **Fix failures immediately**: If any tests fail, fix the issues before proceeding. Do not leave the codebase in a broken state.

4. **Report results**: Always show the user the test results, including:
   - Number of tests passed/failed
   - Details of any failures
   - The console input/output for transparency

**When to skip testing:**
- Documentation-only changes (README, comments)
- Configuration file changes that don't affect functionality
- Test file updates themselves

**IMPORTANT**: Always run tests before committing code changes to ensure the application works as expected.
