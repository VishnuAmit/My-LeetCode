package Dynamic_Programming.Hard;
// Problem link: https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
class Solution{
    // static int helper(int i, int j, int arr[],int[][] dp){
    //     if(i==j) return 0;
    //     int min=Integer.MAX_VALUE;
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     for(int k=i;k<j;k++){
    //         int temp=arr[i-1]*arr[k]*arr[j]+helper(i,k,arr,dp)+helper(k+1,j,arr,dp);
    //         min=Math.min(min,temp);
    //     }
    //     return dp[i][j]=min;
    // }
    static int matrixMultiplication(int N, int arr[])
    {
    //   // Memoization - tc: O(n3) sc: O(n2 + n)
    //   int[][] dp=new int[N][N];
    //   for(int rows[]: dp){
    //       Arrays.fill(rows,-1);
    //   }
    //   return helper(1,N-1,arr,dp);
    
    // Tabulation - tc: O(n3) sc: O(n2)
        int[][] dp=new int[N][N];
        for(int i=1;i<N;i++){
            dp[i][i]=0;
        }
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int temp=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    min=Math.min(min,temp);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][N-1];
        
        
    }
}