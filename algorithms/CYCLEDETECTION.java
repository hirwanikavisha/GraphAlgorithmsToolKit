package algorithms;
import graph.GRAPH;

import java.util.*;
public class CYCLEDETECTION {
    public static boolean hasCycle(GRAPH graph) {
        if (graph.isDirected()) {
            return hasCycleDirected(graph);
        } else {
            return hasCycleUndirected(graph);
        }
    }
    public static boolean hasCycleDirected(GRAPH graph){
        int n=graph.getVertices();
        int[] vis=new int[n];   // 0 for unvisited,1 for visited,2 for visited as well as path visited
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(dfsDirected(graph,vis,i)) return true;
            }
        }
        return false;
    }
    public static boolean dfsDirected(GRAPH graph,int[] vis,int node){
        vis[node]=2;
        List<Integer> ls=graph.getNeighbors(node);
        for(int i=0;i<ls.size();i++){
        if(vis[ls.get(i)]==0){
            if(dfsDirected(graph,vis,ls.get(i))) return true;
        }
        else if(vis[ls.get(i)]==2){
            return true;
        }
        }
        vis[node]=1;
        return false;
    }
    public static boolean hasCycleUndirected(GRAPH graph){
        int n=graph.getVertices();
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(dfsUndirected(graph,i,-1,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfsUndirected(GRAPH graph,int node,int parent,int[] vis){
        vis[node]=1;
        List<Integer> ls=graph.getNeighbors(node);
        for(int i=0;i<ls.size();i++){
            if(vis[ls.get(i)]==0){
                if(dfsUndirected(graph,ls.get(i),node,vis)) return true;
            }
            else if(ls.get(i)!=parent){
                return true;
            }
        }
        return false;
    }
}
