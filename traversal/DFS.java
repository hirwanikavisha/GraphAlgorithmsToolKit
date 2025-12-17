package traversal;
import graph.GRAPH;

import java.util.*;
public class DFS {
    public static void run(GRAPH graph,int start){
     int n=graph.getVertices();
     int[] vis=new int[n];
     System.out.print("DFS Traversal: ");
     helper(graph,start,vis);
     for(int i=0;i<n;i++){
        if(vis[i]==0){
            helper(graph,i,vis);
        }
     }
    }
    public static void helper(GRAPH graph,int node,int[] vis){
      System.out.print(node+" ");
      vis[node]=1;
      List<Integer> ls=graph.getNeighbors(node);
      for(int i=0;i<ls.size();i++){
        if(vis[ls.get(i)]==0){
            helper(graph,ls.get(i),vis);
        }
      }
    }
}