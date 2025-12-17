package traversal;
import graph.GRAPH;

import java.util.*;
public class BFS {
    public static void run(GRAPH graph,int start){
     int n=graph.getVertices();
     int[] vis=new int[n];
     System.out.print("BFS Traversal: ");
     helper(graph,vis,start);
     for(int i=0;i<n;i++){
        if(vis[i]==0){
            helper(graph,vis,i);
        }
     }
    }
    public static void helper(GRAPH graph,int[] vis,int node){
     Queue<Integer> q=new LinkedList<>();
     q.offer(node);
     vis[node]=1;
     while (!q.isEmpty()) {
            int poll = q.poll();
            System.out.print(poll + " ");

            for (int neighbor : graph.getNeighbors(poll)) {
                if (vis[neighbor]==0) {
                    vis[neighbor] = 1;
                    q.offer(neighbor);
                }
            }
        }

        System.out.println();
    }
}
