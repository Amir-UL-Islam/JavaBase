## Base: Java and Kotlin Learning Playground

This repository is a collection of small Java (and a few Kotlin) exercises, examples, and algorithms. It includes
language basics, data structures, problem-solving snippets, and concurrency demos. Most classes are standalone and
meant to be compiled/run individually.

### Contents at a Glance

- `src/`: Ad hoc Java examples (basics, arrays, IO, regex, etc.)
- `src/com/aiokleo/problemSolving/`: Algorithm practice (two-sum, LRU cache, recursion, string/array tasks)
- `src/com/aiokleo/graph/` and `src/com/aiokleo/tree/`: Graph/tree examples and traversal problems
- `src/com/aiokleo/threads/`: Threading, futures, executors, and race condition demonstrations
- `src/com/aiokleo/annotation/` and `src/com/aiokleo/annotations/`: Annotation usage and exercises
- `src/com/aiokleo/*Pattern*` and design/principle folders: OOP principles and design patterns
- `src/com/aiokleo/kotlin*` and `.kt` files: Kotlin language examples

### Build and Run

This project uses Gradle with the Java plugin. There is no single application entry point, so compile/run the class
you want.

Compile a specific class:

```bash
javac src/com/aiokleo/problemSolving/twoSum/TwoSum.java
```

Run it (adjust the classpath and main class as needed):

```bash
java -cp src com.aiokleo.problemSolving.twoSum.TwoSum
```


### Notes

- The repo contains compiled `.class` files and IDE metadata in some folders; these are not required to build/run.
- Many examples read from standard input or print to standard output; check each class for usage details.

### Suggested Workflow

- Use an IDE (IntelliJ IDEA) for browsing and running individual classes.
- Search by topic or package to locate examples relevant to a concept.
