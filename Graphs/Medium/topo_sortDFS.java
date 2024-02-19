package Graphs.Medium;
import java.util.*;
// Problem link: https://www.geeksforgeeks.org/problems/topological-sort/1
class Solution
{
    static void helper(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node]=1;
        for(Integer it: adj.get(node)){
            if(vis[it]==0){
                helper(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
      // tc: O(V+E) sc: O(3V)
      Stack<Integer> st=new Stack<>();
      int vis[]=new int[V];
      for(int i=0;i<V;i++){
          if(vis[i]==0){
              helper(i, vis, adj,st);
          }
      }
      
      int ind=0;
      int[] topo=new int[V];
      while(!st.isEmpty()){
          topo[ind++]=st.pop();
      }
      return topo;
    }
}

