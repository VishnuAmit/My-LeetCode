// Problem link: https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
class solve {
    public boolean issafe(boolean graph[][], int[] color, int node, int c){
        for(int i=0;i<graph.length;i++){
            if(graph[node][i] & color[i]==c) return false;
        }
        return true;
    }
    
    public boolean solver(boolean graph[][], int color[], int node,int m){
        if(node==graph.length) return true;
        
        for(int i=1;i<=m;i++){
            if(issafe(graph,color,node,i)){
                color[node]=i;
                if (solver(graph,color,node+1,m)==true) return true;
                color[node]=0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Optimal - tc: O(n^m) sc: O(n)
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = 0;
        }

        if (!solver(graph, color,0, m)) {
            return false;
        }
        return true;
    }
}