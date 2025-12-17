# 📊 Graph Algorithms Toolkit (Java)

A **Java-based Graph Algorithms Toolkit** for learning, practicing, and demonstrating fundamental graph algorithms.  
This project is designed to be **modular, reusable, and easy to understand**, with a **menu-driven demo program** to interactively test algorithms.

---

## 💡 Project Overview

Graphs are a core topic in Data Structures & Algorithms.  
This toolkit provides:

- A **Graph data structure** using adjacency lists  
- Implementations of **core graph algorithms**  
- A **menu-driven demo program** to test BFS, DFS, cycle detection, bipartite check, and topological sort  
- A learning-friendly structure for understanding algorithm behavior  

---

## ✨ Features

- **Graph Representation**: Adjacency List  
- **Graph Types**: Directed and Undirected  
- **Traversals**: BFS and DFS  
- **Cycle Detection**:  
  - Directed graphs (DFS with recursion stack)  
  - Undirected graphs (DFS with parent tracking)  
- **Bipartite Graph Checking** using BFS coloring  
- **Topological Sorting** (Kahn’s Algorithm) for DAGs  
- **Interactive Menu** for creating graphs and running algorithms  

---

## 🗂 Project Structure

``` GraphAlgorithmsToolKit/
├── graph/
│ └── GRAPH.java # Graph data structure
├── traversal/
│ ├── BFS.java # Breadth First Search
│ └── DFS.java # Depth First Search
├── algorithms/
│ ├── CYCLEDETECTION.java # Cycle detection
│ ├── BIPARTITE.java # Bipartite check
│ └── TOPOLOGICALSORT.java # Topological sort
├── Main.java # Menu-driven demo program
└── README.md # Project description
``` 


# ⚙️ Installation & Setup Guide

This guide helps you set up and run the **Graph Algorithms Toolkit** on a brand-new laptop (Windows, Mac, or Linux). All commands are included in code blocks for easy copy-paste.

---

## 1. Prerequisites

### 1.1 Java Development Kit (JDK 8+)

Verify installation:

```bash
java -version
```

If Java is not installed, download and install from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or OpenJDK.

---

### 1.2 Git

Verify installation:

```bash
git --version
```

If Git is not installed, download and install from [Git Official Website](https://git-scm.com/downloads).

> Tip: On Windows, you can use Git Bash for a Linux-like terminal.

---

## 2. Clone the Project

Open a terminal or command prompt and run:

```bash
git clone https://github.com/hirwanikavisha/GraphAlgorithmsToolKit.git
cd GraphAlgorithmsToolKit
```

---

## 3. Compile the Project

Create a folder for compiled files:

```bash
mkdir bin
```

Compile all Java files into the `bin` directory:

```bash
javac -d bin $(find . -name "*.java")
```

> On Windows Command Prompt, use:

```bash
javac -d bin $(dir /s /b *.java)
```

---

## 4. Run the Project (Terminal)

Run the main class:

```bash
java -cp bin Main
```

> If your main class is inside a package, use the full package name (e.g., `main.Main`).

Follow the menu to create graphs and run algorithms.

---

## 5. Open & Run in VS Code

1. Open VS Code → File → Open Folder → Select `GraphAlgorithmsToolKit`.
2. Install the **Java Extension Pack**.
3. Open `Main.java`.
4. Click **Run ▶️** to execute.
5. Use **Run and Debug** for breakpoints and step-by-step execution.

---

## 6. Quick Usage

1. Launch the program (terminal or VS Code).
2. Create a graph (directed or undirected).
3. Select an algorithm: BFS, DFS, Cycle Detection, Bipartite Check, or Topological Sort.
4. View results in the console.

---

## 7. Tips for a New Laptop

- Ensure **JDK and Git** are installed.
- Use **VS Code** for easier compilation and debugging.
- Always run commands from the **project root folder** (`GraphAlgorithmsToolKit`).
```
