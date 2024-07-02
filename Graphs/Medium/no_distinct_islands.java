package Graphs.Medium;
import java.util.ArrayList;
import java.util.HashSet;
// Problem link: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
class Solution {
    void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> ans, int row0, int col0){
        vis[row][col]=1;
        ans.add(toString(row-row0, col-col0));
        int n=grid.length;
        int m=grid[0].length;
        
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,-1,0,+1};
        
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,vis,grid,ans,row0,col0);
            }
        }
    }
    
    private String toString(int r, int c){
        return Integer.toString(r) +" "+Integer.toString(c);
    }
    int countDistinctIslands(int[][] grid) {
          // tc: O(nm*log(nm))+O(4nm) sc: O(nm)
          int n=grid.length;
          int m=grid[0].length;
          int[][] vis=new int[n][m];
          HashSet<ArrayList<String>> set=new HashSet<>();
          for(int i=0;i<n;i++){
              for(int j=0;j<m;j++){
                  if(vis[i][j]==0 && grid[i][j]==1){
                      ArrayList<String> ans=new ArrayList<>();
                      dfs(i,j,vis,grid,ans,i,j);
                      set.add(ans);
                  }
              }
          }
          return set.size();
    }
  }
