package Graphs.Medium;
import java.util.*;
// Problem link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // tc: O(V+E) sc: O(2V)
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            Integer node=q.peek();
            q.poll();
            cnt++;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(cnt==V) return false;
        else return true;
    }
}
