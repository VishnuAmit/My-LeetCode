package Medium;
// Problem link: https://leetcode.com/problems/unique-paths/
class Solution {
    // // Brute force - tc: exp sc: exp
    // public static int countpaths(int i, int j, int m, int n){
    //     if(i==(m-1) && j==(n-1)) return 1;
    //     if(i>=m || j>=n) return 0;
    //     else return countpaths(i+1,j,m,n) + countpaths(i,j+1,m,n);

    // }

    // // Better - tc: O(nm) sc: O(nm)
    // public static int countpaths(int i, int j, int m, int n, int dp[][]){
    //     if(i==(m-1) && j==(n-1)) return 1;
    //     if(i>=m || j>=n) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     else return dp[i][j]=countpaths(i+1,j,m,n,dp) + countpaths(i,j+1,m,n,dp);

    // }
    public int uniquePaths(int m, int n) {
    //    return countpaths(0,0,m,n);

    // int[][] dp=new int[m][n];
    // for(int i=0;i<m;i++){
    //     Arrays.fill(dp[i],-1);
    // }
    // return countpaths(0,0,m,n,dp);

    // Optimal - tc: O(n-1) sc: O(1);
    int N=n+m-2;
    int r=m-1;
    double res=1;
    for(int i=1;i<=r;i++){
        res=res*(N-r+i)/i;
    }
    return (int)res;
    }
}
