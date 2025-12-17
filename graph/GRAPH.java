package graph;
import java.util.*;
public class GRAPH {
    private int vertices;                     
    private List<List<Integer>> adjList;  
    private boolean directed; 
    // Constructor         
    public GRAPH(int n,boolean isDirected){
        this.vertices=n;
        this.directed=isDirected;
        adjList=new ArrayList<>();
        for(int i=0;i<n;i++){                // 0-based indexing
            adjList.add(new ArrayList<>());
        }
    }
    // Add Edge in a graph
    public void addEdge(int u,int v){
        adjList.get(u).add(v);
        if(!directed){
            adjList.get(v).add(u);
        }
    }
    // Get all the neighbors of the node
    public List<Integer> getNeighbors(int u) {
        return adjList.get(u);
    }
    // Get vertices in a graph
    public int getVertices() {
        return vertices;
    }
    // Check if graph is directed or not(undirected)
    public boolean isDirected() {
        return directed;
    }
    // print adjacency list
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            List<Integer> ls=adjList.get(i);
            for (int j=0;j<ls.size();j++) {
                System.out.print(ls.get(j) + " ");
            }
            System.out.println();
        }
    }
}