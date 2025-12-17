import java.util.*;
import graph.GRAPH;
import traversal.BFS;
import traversal.DFS;
import algorithms.CYCLEDETECTION;
import algorithms.BIPARTITE;
import algorithms.TOPOLOGICALSORT;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static GRAPH graph = null;
    
    public static void main(String[] args) {
        System.out.println("===== GRAPH ALGORITHMS TOOLKIT DEMO =====");
        System.out.println("A demonstration of reusable graph algorithms library");
        System.out.println("===========================================\n");
        
        boolean exit = false;
        
        while (!exit) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice (0-7): ", 0, 7);
            
            switch (choice) {
                case 1:
                    createNewGraph();
                    break;
                case 2:
                    addEdges();
                    break;
                case 3:
                    runBFS();
                    break;
                case 4:
                    runDFS();
                    break;
                case 5:
                    checkCycles();
                    break;
                case 6:
                    checkBipartite();
                    break;
                case 7:
                    runTopologicalSort();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using Graph Algorithms Toolkit!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            if (choice != 0) {
                System.out.println("\nPress Enter to continue...");
                sc.nextLine();
                sc.nextLine(); // Wait for Enter key
            }
        }
        
        sc.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Create a new graph");
        System.out.println("2. Add edges to current graph");
        System.out.println("3. Run BFS traversal");
        System.out.println("4. Run DFS traversal");
        System.out.println("5. Check for cycles");
        System.out.println("6. Check if graph is bipartite");
        System.out.println("7. Run topological sort (for directed graphs)");
        System.out.println("0. Exit");
        System.out.println("=================");
    }
    
    private static void createNewGraph() {
        System.out.println("\n--- CREATE NEW GRAPH ---");
        int vertices = getIntInput("Enter number of vertices: ", 1, 100);
        
        boolean directed = getYesNoInput("Is this a directed graph? (y/n): ");
        
        graph = new GRAPH(vertices, directed);
        System.out.println("✓ Graph created successfully!");
        System.out.println("  - Vertices: 0 to " + (vertices - 1));
        System.out.println("  - Type: " + (directed ? "Directed" : "Undirected"));
    }
    
    private static void addEdges() {
        if (graph == null) {
            System.out.println("Please create a graph first (Option 1)!");
            return;
        }
        
        System.out.println("\n--- ADD EDGES ---");
        System.out.println("Current graph has " + graph.getVertices() + " vertices (0 to " + (graph.getVertices() - 1) + ")");
        
        boolean adding = true;
        while (adding) {
            System.out.println("\nAdd an edge (format: source destination):");
            System.out.print(">>> ");
            
            try {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                if (src < 0 || src >= graph.getVertices() || 
                    dest < 0 || dest >= graph.getVertices()) {
                    System.out.println("Error: Vertex numbers must be between 0 and " + (graph.getVertices() - 1));
                    continue;
                }
                
                graph.addEdge(src, dest);
                System.out.println("✓ Edge added: " + src + " -> " + dest);
                
                // For undirected graphs, inform user
                if (!graph.isDirected()) {
                    System.out.println("  (Undirected edge: " + dest + " -> " + src + " also added)");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid integers.");
                sc.nextLine(); // Clear invalid input
                continue;
            }
            
            adding = getYesNoInput("Add another edge? (y/n): ");
        }
        
        System.out.println("\n✓ Edge addition complete.");
    }
    
    private static void runBFS() {
        if (graph == null) {
            System.out.println("Please create a graph first!");
            return;
        }
        
        System.out.println("\n--- BFS TRAVERSAL ---");
        int start = getIntInput("Enter starting vertex (0-" + (graph.getVertices() - 1) + "): ", 
                               0, graph.getVertices() - 1);
        
        System.out.println("\nBFS traversal starting from vertex " + start + ":");
        BFS.run(graph, start);
    }
    
    private static void runDFS() {
        if (graph == null) {
            System.out.println("Please create a graph first!");
            return;
        }
        
        System.out.println("\n--- DFS TRAVERSAL ---");
        int start = getIntInput("Enter starting vertex (0-" + (graph.getVertices() - 1) + "): ", 
                               0, graph.getVertices() - 1);
        
        System.out.println("\nDFS traversal starting from vertex " + start + ":");
        DFS.run(graph, start);
    }
    
    private static void checkCycles() {
        if (graph == null) {
            System.out.println("Please create a graph first!");
            return;
        }
        
        System.out.println("\n--- CYCLE DETECTION ---");
        System.out.println("Graph type: " + (graph.isDirected() ? "Directed" : "Undirected"));
        
        boolean hasCycle = CYCLEDETECTION.hasCycle(graph);
        
        if (hasCycle) {
            System.out.println("✗ Graph CONTAINS a cycle");
        } else {
            System.out.println("✓ Graph is ACYCLIC (no cycles)");
        }
        
        // Additional info for directed graphs
        if (graph.isDirected() && hasCycle) {
            System.out.println("Note: A directed graph with cycles cannot have a valid topological sort.");
        }
    }
    
    private static void checkBipartite() {
        if (graph == null) {
            System.out.println("Please create a graph first!");
            return;
        }
        
        // While bipartite check can work on directed graphs by ignoring direction,
        // it's more standard for undirected graphs
        if (graph.isDirected()) {
            System.out.println("Note: Bipartite check is typically for undirected graphs.");
            System.out.println("Will convert to undirected representation for this check.");
        }
        
        System.out.println("\n--- BIPARTITE CHECK ---");
        
        boolean isBipartite = BIPARTITE.isBipartite(graph);
        
        if (isBipartite) {
            System.out.println("✓ Graph is BIPARTITE");
            System.out.println("  - Can be colored with 2 colors such that no adjacent vertices share the same color");
            System.out.println("  - Contains no odd-length cycles");
        } else {
            System.out.println("✗ Graph is NOT bipartite");
            System.out.println("  - Contains at least one odd-length cycle");
        }
    }
    
    private static void runTopologicalSort() {
        if (graph == null) {
            System.out.println("Please create a graph first!");
            return;
        }
        
        if (!graph.isDirected()) {
            System.out.println("Error: Topological sort requires a DIRECTED graph.");
            System.out.println("Please create a directed graph (Option 1, choose 'y' for directed).");
            return;
        }
        
        System.out.println("\n--- TOPOLOGICAL SORT ---");
        System.out.println("Note: Only valid for Directed Acyclic Graphs (DAGs)");
        
        List<Integer> topoOrder = TOPOLOGICALSORT.topoSort(graph);
        
        if (topoOrder.isEmpty()) {
            System.out.println("✗ Graph contains a cycle! Topological sort not possible.");
            System.out.println("  - Use Option 5 to verify cycle detection");
        } else {
            System.out.println("✓ Valid topological order found:");
            System.out.print("  [");
            for (int i = 0; i < topoOrder.size(); i++) {
                System.out.print(topoOrder.get(i));
                if (i < topoOrder.size() - 1) {
                    System.out.print(" → ");
                }
            }
            System.out.println("]");
            
            System.out.println("\nInterpretation: For task scheduling, this represents a valid order");
            System.out.println("where each task comes before its dependent tasks.");
        }
    }
    
    // ===== HELPER METHODS =====
    
    private static int getIntInput(String prompt, int min, int max) {
        int value = -1;
        while (value < min || value > max) {
            System.out.print(prompt);
            try {
                value = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                if (value < min || value > max) {
                    System.out.println("Please enter a value between " + min + " and " + max);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                sc.nextLine(); // Clear invalid input
            }
        }
        return value;
    }
    
    private static boolean getYesNoInput(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim().toLowerCase();
        
        while (!input.equals("y") && !input.equals("n") && 
               !input.equals("yes") && !input.equals("no")) {
            System.out.print("Please enter 'y' or 'n': ");
            input = sc.nextLine().trim().toLowerCase();
        }
        
        return input.equals("y") || input.equals("yes");
    }
}