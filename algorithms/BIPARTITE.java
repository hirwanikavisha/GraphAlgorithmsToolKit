package algorithms;
import java.util.*;
import graph.GRAPH;

public class BIPARTITE {
    public static boolean isBipartite(GRAPH graph) {
        // Bipartite property is generally for undirected graphs
        if (graph.isDirected()) {
            return false;
        }
        int n = graph.getVertices();
        int[] color = new int[n];
        Arrays.fill(color, -1);   // -1 = uncolored
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(GRAPH graph, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : graph.getNeighbors(node)) {
                if (color[nei] == -1) {
                    color[nei] = 1 - color[node];
                    q.offer(nei);
                } 
                else if (color[nei] == color[node]) {
                    return false;   // conflict
                }
            }
        }
        return true;
    }
}
