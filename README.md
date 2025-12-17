Graph Algorithms Toolkit

A Java-based interactive toolkit to demonstrate common graph algorithms using a reusable graph library. This project is designed for learning, experimentation, and demonstration of graph algorithms such as BFS, DFS, cycle detection, bipartite check, and topological sort.

Features

Create Graphs

Support for directed and undirected graphs

Custom number of vertices

Add Edges

Interactive input of edges

Validation for vertex indices

Traversals

BFS (Breadth-First Search)

DFS (Depth-First Search)

Cycle Detection

Detect cycles in directed or undirected graphs

Bipartite Check

Determine if the graph is bipartite

Inform about odd-length cycles if not bipartite

Topological Sort

Works for Directed Acyclic Graphs (DAGs)

Prints a valid task ordering

Getting Started
Prerequisites

Java JDK 8+

IDE or terminal for compilation

Running the Project

Compile all classes:

javac -d bin src/**/*.java


Run the main program:

java -cp bin Main


Follow the interactive menu:

Create a new graph

Add edges

Run BFS or DFS

Check cycles or bipartite status

Perform topological sort (for DAGs)

Project Structure
/src
 ├─ Main.java          // Interactive menu and toolkit demo
 ├─ graph
 │    └─ GRAPH.java    // Graph class (vertices, edges, adjacency list)
 ├─ traversal
 │    ├─ BFS.java
 │    └─ DFS.java
 └─ algorithms
      ├─ CYCLEDETECTION.java
      ├─ BIPARTITE.java
      └─ TOPOLOGICALSORT.java

Usage Example

Create a directed graph with 5 vertices.

Add edges: 0→1, 0→2, 1→3, 3→4

Run BFS starting from 0 → Output: 0 1 2 3 4

Check cycle detection → Output: Graph is acyclic

Run topological sort → Output: 0 → 2 → 1 → 3 → 4

Notes

Bipartite checks are typically for undirected graphs, but this tool allows checking directed graphs by ignoring edge directions.

Topological sort is only valid for DAGs. If the graph contains a cycle, the toolkit will inform you.

Designed for educational purposes and to demonstrate reusable graph algorithms in Java.

Author

Kavisha Hirwani – Learning and exploring graph algorithms in Java.