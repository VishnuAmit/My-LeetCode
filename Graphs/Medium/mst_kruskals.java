package Graphs.Medium;
import java.util.*;
// Problem link: https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }
    
        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
    
        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int _src, int _dest, int _wt) {
            this.src = _src; this.dest = _dest; this.weight = _wt;
        }
        // Comparator function used for
        // sorting edgesbased on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };
    
    class Solution{
        static int spanningTree(int V, int E, int edges[][]){
            // tc: O(n+e) + O(eloge) + O(E*4alpha*2) sc: O(2N+E)
            List<Edge> edgeList = new ArrayList<Edge>();
            // Constructing the edge list from the given adjacency matrix
            for (int i = 0; i < E; i++) {
                int src = edges[i][0];
                int dest = edges[i][1];
                int weight = edges[i][2];
                Edge edge = new Edge(src, dest, weight);
                edgeList.add(edge);
            }
            // Sorting the edges by weight
            Collections.sort(edgeList);
            
            DisjointSet ds = new DisjointSet(V);
            int mstWeight = 0;
            for (Edge edge : edgeList) {
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                // Checking if adding this edge forms a cycle
                if (ds.findUPar(src) != ds.findUPar(dest)) {
                    mstWeight += weight;
                    ds.unionBySize(src, dest);
                }
            }
            return mstWeight;
        }
    }
    