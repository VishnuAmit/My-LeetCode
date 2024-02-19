package Graphs.Easy;
// Problem link: https://leetcode.com/problems/flood-fill/
class Solution {
    public void dfs(int row, int col, int[][] ans, int[][] image, int color, int inicolor, int[] delrow, int[] delcol){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=color && image[nrow][ncol]==inicolor){
                dfs(nrow,ncol,ans,image,color,inicolor,delrow,delcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // tc: O(4nm) sc: O(nm+nm)
        int inicolor=image[sr][sc];
        int [][] ans =image;
        int[] delrow={-1,0,+1,0};
        int[] delcol={0,-1,0,+1};
        dfs(sr,sc,ans,image,color,inicolor,delrow,delcol);
        return ans;
    }
}