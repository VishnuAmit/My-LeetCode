package Graphs.Medium;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// Problem link: https://leetcode.com/problems/is-graph-bipartite/
class Solution {
    private boolean helper(int start, int n, int[][] graph, int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            for(Integer it: graph[node]){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }else if(color[it]==color[node]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        // tc: O(V+2E) sc: O(3V)
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(helper(i,n,graph,color)==false) return false;
            }
        }
        return true;
    }
}