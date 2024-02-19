package Graphs.Medium;
import java.util.*;
class Solution {
    public boolean helper(int[] vis, int[] pathvis,  ArrayList<ArrayList<Integer>> adj, int node){
        vis[node]=1;
        pathvis[node]=1;
        
        for(Integer it: adj.get(node)){
            if(vis[it]==0){
                if(helper(vis,pathvis,adj,it)==true) return true;
            }else if(pathvis[it]==1){
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // tc: O(V+E) sc: O(2V)
       int[] vis=new int[V];
       int[] pathvis=new int[V];
       for(int i=0;i<V;i++){
           if(vis[i]==0){
               if(helper(vis,pathvis,adj,i)==true) return true;
           }
       }
       return false;
    }
}