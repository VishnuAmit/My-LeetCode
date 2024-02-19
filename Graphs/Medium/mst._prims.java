package Graphs.Medium;
import java.util.*;
// Problem link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
class pair{
    int node;
    int distance;
    
    pair(int node,int distance){
        this.node = node;
        this.distance = distance;
    }
}

class Solution{
	static int spanningTree(int n, int E, int edges[][]){
	    // tc: O(2E+logE) sc: O(E+V)
	   int vis[] = new int[n];
	  
	   PriorityQueue<pair>pq = new PriorityQueue<pair>((x,y) -> x.distance - y.distance);
	   ArrayList<ArrayList<pair>>adj = new ArrayList<>();
	  
	    
	   for(int i=0;i<n;i++){
	       adj.add(new ArrayList<>());
	   }
	   
	   for(int i=0;i<E;i++){
	       adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
	       adj.get(edges[i][1]).add(new pair(edges[i][0],edges[i][2]));
	  
	   }
	   
	   //adding the first element in the priority queue 
	   pq.add(new pair(0,0));
	   int sum = 0;  
	   while(!pq.isEmpty()){
    	    int node = pq.peek().node;
	        int edgewt = pq.peek().distance;
	        pq.poll();
	        
	        if(vis[node] == 0){
	            vis[node] = 1;
	            sum+=edgewt;
	            
	            for(pair it:adj.get(node)){
	                if(vis[it.node] == 0){
	                    pq.add(new pair(it.node,it.distance));
	                }    
	            }
	        } 
	}
        
        return sum;
        
	}
}