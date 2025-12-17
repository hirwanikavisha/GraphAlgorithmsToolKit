package algorithms;
import graph.GRAPH;

import java.util.*;
public class TOPOLOGICALSORT {
    // kahn's Algo
    public static List<Integer> topoSort(GRAPH graph) {
        // Topological sort is only for directed graphs
        if (!graph.isDirected()) {
            return new ArrayList<>();
        }
        int n = graph.getVertices();
        int[] indegree = new int[n];
        // Calculate indegree
        for (int i = 0; i < n; i++) {
            for (int nei : graph.getNeighbors(i)) {
                indegree[nei]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int nei : graph.getNeighbors(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        // If topo size != number of vertices → cycle exists
        if (topo.size() != n) {
            return new ArrayList<>(); // cycle present(empty list)
        }
        return topo;
    }
}
