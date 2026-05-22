# Upgrade Plan: JUEGOSDUOC (20260522082257)

- **Generated**: 2026-05-22 08:22:57
- **HEAD Branch**: main
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- JDK 21: **<TO_BE_INSTALLED>** (required by step 1 and step 2)
- Global JDK: not available (baseline and validation require installation)

**Build Tools**
- Maven Wrapper: 3.9.15 (available, compatible with Java 21)
- Global Maven: not available

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260522082257
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade the project runtime to the latest LTS Java version: Java 21

## Technology Stack

| Technology/Dependency    | Current | Min Compatible | Why Incompatible |
| ------------------------ | ------- | -------------- | ---------------------------------------------- |
| Java                     | 21      | 21             | User-requested latest LTS; project already targets Java 21 |
| Spring Boot              | 4.0.6   | 4.0.6          | Already compatible with Java 21 |
| Maven Wrapper            | 3.9.15  | 3.9.0          | Compatible with Java 21 |
| maven-compiler-plugin    | managed by Spring Boot | 3.11.0+ | Required for Java 21 bytecode; managed by current BOM |

## Derived Upgrades

- Install JDK 21 for the build and test environment because no local JDK installation was discovered.
- No dependency or Spring Boot version upgrade is needed because the project already targets Java 21 with Spring Boot 4.0.6.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| pom.xml | `java.version` | 21 | verify | 21 | Project already targets the requested Java runtime |

### Source Code Changes

| File | Location | Current | Required Change | Reason |
|------|----------|---------|----------------|--------|
| None | N/A | N/A | N/A | No source code changes are required for the runtime upgrade |

### Configuration Changes

| File | Property/Setting | Current | Required Change | Reason |
|------|------------------|---------|----------------|--------|
| None | N/A | N/A | N/A | No configuration changes required for Java 21 runtime support |

### CI/CD Changes

| File | Location | Current | Required Change |
|------|----------|---------|----------------|
| None found | N/A | N/A | N/A |

### Risks & Warnings

- **Missing local JDK**: No JDK installations were discovered by the tooling. Mitigation: install JDK 21 via `appmod-install-jdk` and use the Maven wrapper for verification.
- **Wrapper dependency**: The build relies on Maven Wrapper 3.9.15. If network restrictions prevent wrapper distribution download, install a compatible global Maven 3.9+ binary instead.
- **Stashed local modifications**: Uncommitted changes were stashed before plan generation. The upgrade will proceed from a clean working tree and should not modify those pending edits.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: No local JDK was found by tooling, but Java 21 runtime support is required for compilation and testing.
  - **Changes to Make**: Install JDK 21 and confirm Maven Wrapper 3.9.15 compatibility.
  - **Verification**: Run `./mvnw.cmd -version` or `.\mvnw.cmd -version`; expected JDK 21 and Maven 3.9.15.

- Step 2: Baseline Verification
  - **Rationale**: Confirm that the current source code compiles and tests successfully with the target runtime before any upgrade-related changes.
  - **Changes to Make**: Run baseline build and test commands on the existing project state.
  - **Verification**: Run `.\mvnw.cmd clean compile test-compile -q && .\mvnw.cmd clean test -q`; expected success.

- Step 3: Final Validation
  - **Rationale**: Validate the runtime upgrade end-to-end and ensure all tests pass on Java 21.
  - **Changes to Make**: Execute a final clean build and full test run with the confirmed Java 21 environment.
  - **Verification**: Run `.\mvnw.cmd clean test -q`; expected success.
