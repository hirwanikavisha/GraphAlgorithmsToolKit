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
