# Design & Framework Justification

## Assignment Objective

Create a Windows console application that takes exactly one argument (the absolute image path) and counts the number of vertical black lines in a black-and-white JPG image.

---

## Chosen Technology

**Java SE (Standard Edition) – Core Java (no external frameworks)**

---

## Reasoning

The assignment specifies a console-based application that must take a single command-line argument. Using plain Java ensures the program runs on any system with a standard JDK installation and requires no special environment setup.

This choice provides **maximum portability**, **simplicity**, and **direct alignment with TMMC’s requirements**. It allows the solution to be executed from the command line on Windows, macOS, or Linux without dependencies.

While no frameworks were required, the solution still follows **industry-standard design and architectural principles**:

### SOLID Principles

Each class has a single responsibility and follows abstraction and dependency inversion.

### Design Patterns Used

* **Singleton** – `LineCounterService` ensures one shared instance for consistent logic.
* **Factory** – `ImageReaderFactory` centralizes image reader creation.
* **Strategy** – `ImageReader` interface allows support for multiple image formats in the future.

This demonstrates clean design, modularity, and scalability, even in a simple console context.

The application handles all expected edge cases:

* Validates that only one argument or one input path is provided.
* Detects invalid or missing files.
* Manages unexpected errors without crashing.
* Provides user feedback and clear log messages.

---

## Alternative Considerations

* **Spring Boot CLI:** Considered for enterprise-style structure but not chosen, as it would add unnecessary complexity and dependencies for a single-task console utility.
* **Node.js or Python:** Could simplify image reading, but Java better reflects enterprise and manufacturing application environments where Java is commonly used for system integrations.
* **Maven or Gradle:** A build system was considered but not required since the project’s simplicity allows direct compilation via `javac`, ensuring easy evaluation and minimal setup.

---

## Design Philosophy

The goal was to implement a **simple, maintainable, and production-ready** console utility that demonstrates:

* Strong understanding of **object-oriented principles**.
* Professional-level **exception handling** and **input validation**.
* Modular package organization and separation of concerns consistent with SOLID principles.
* Clean, extensible structure suitable for both standalone execution and future integration into larger systems (e.g., Spring Boot microservice or manufacturing control subsystem).

---

## Summary

This solution:

* Fully meets all requirements of the assignment.
* Uses standard Java for cross-platform compatibility.
* Applies SOLID and design pattern best practices.
* Balances simplicity, maintainability, and professional-level architecture.
* Can be extended easily to detect horizontal lines or integrated into advanced imaging frameworks in the future.

> **In short:** Plain Java SE was intentionally chosen for its portability, clarity, maintainability, and close alignment with the stated task.
