package Medium;
// Problem link: https://leetcode.com/problems/minimum-path-sum/
class Solution {
    // public int helper(int i, int j, int[][] mat, int[][]dp){
    //     if(i==0 && j==0) return mat[0][0];
    //     if(i<0 || j<0) return (int) Math.pow(10, 9);
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int up=mat[i][j]+helper(i-1,j,mat,dp);
    //     int left=mat[i][j]+helper(i,j-1,mat,dp);

    //     dp[i][j]=Math.min(up,left);
    //     return dp[i][j];
    // }
    public int minPathSum(int[][] grid) {
        // // Memoization - tc: O(nm) sc: O(nm+(n+m))
        // int n=grid.length;
        // int m=grid[0].length;
        // int[][] dp=new int[n][m];
        // for(int[] rows: dp){
        //     Arrays.fill(rows,-1);
        // }
        // return helper(n-1,m-1,grid,dp);

        // // Tabulation - tc: O(nm) sc: O(nm)
        // int n=grid.length;
        // int m=grid[0].length;
        // int dp[][] = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (i == 0 && j == 0)
        //             dp[i][j] = grid[i][j];
        //         else {
        //             int up = grid[i][j];
        //             if (i > 0)
        //                 up += dp[i - 1][j];
        //             else
        //                 up += (int) Math.pow(10, 9);

        //             int left = grid[i][j];
        //             if (j > 0)
        //                 left += dp[i][j - 1];
        //             else
        //                 left += (int) Math.pow(10, 9);

        //             dp[i][j] = Math.min(up, left);
        //         }
        //     }
        // }

        // return dp[n - 1][m - 1];

        // Space optimization - tc: O(nm) sc: O(m)
        int n=grid.length;
        int m=grid[0].length;
        int [] prev =new int[m];
        int [] cur =new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    cur[j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    if (i > 0)
                        up += prev[j];
                    else
                        up += (int) Math.pow(10, 9);

                    int left = grid[i][j];
                    if (j > 0)
                        left += cur[j - 1];
                    else
                        left += (int) Math.pow(10, 9);

                    cur[j] = Math.min(up, left);
                }
            }
            prev=cur.clone();
        }

        return prev[m - 1];

    }
}
