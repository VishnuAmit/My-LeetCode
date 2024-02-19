package Graphs.Hard;
import java.util.*;
// Problem link: https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
class Solution
{
    // Tc: O(3(V+E)) sc: O(2V+(V+E)) 
    public void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node]=1;
        for(Integer it: adj.get(node)){
            if(visited[it]==0){
                dfs(it,visited,adj,st);
            }
        }
        st.push(node);
    }
    
    public void dfsagn(int node, int[] visited, ArrayList<ArrayList<Integer>> revgraph){
        visited[node]=1;
        for(Integer it: revgraph.get(node)){
            if(visited[it]==0){
                dfsagn(it,visited,revgraph);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] visited=new int[V];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,adj,st);
            }
        }
        
        ArrayList<ArrayList<Integer>> revgraph=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            revgraph.add(new ArrayList<Integer>());
        }
         for (int i = 0; i < V; i++) {
            visited[i] = 0;
            for (Integer it : adj.get(i)) {
                revgraph.get(it).add(i);
            }
        }
        
        int scc=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            if(visited[node]==0){
                scc++;
                dfsagn(node,visited,revgraph);
            }
        }
        return scc;
    }
}

