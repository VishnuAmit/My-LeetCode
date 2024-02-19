// Problem link: https://www.geeksforgeeks.org/problems/rod-cutting0840/1
    class Solution{
        // public int helper(int[] arr, int n, int ind, int[][] dp){
        //     if(ind==0){
        //         return n*arr[0];
        //     }
        //     if(dp[ind][n]!=-1){
        //         return dp[ind][n];
        //     }
        //     int nottake=0+helper(arr, n, ind-1,dp);
        //     int rodlen=ind+1;
        //     int take=Integer.MIN_VALUE;
        //     if(rodlen<=n){
        //         take=arr[ind]+helper(arr,n-rodlen,ind,dp);
        //     }
        //     dp[ind][n]=Math.max(take,nottake);
        //     return dp[ind][n];
        // }
        public int cutRod(int price[], int n) {
        //   // Memoization - tc: O(nN) sc: O(nN +(n))
        //   int N=price.length;
        //   int[][] dp=new int[N][n+1];
        //   for(int rows[]:dp){
        //       Arrays.fill(rows,-1);
        //   }
        //   return helper(price,n,n-1,dp);
          
        //   // Tabulation - tc: O(nN) sc: O(nN);
        //   int len=price.length;
        //   int[][] dp=new int[len][n+1];
        //   for(int i=0;i<=n;i++){
        //       dp[0][i]=i*price[0];
        //   }
        //   for(int ind=1;ind<n;ind++){
        //       for(int N=0;N<=n;N++){
        //             int nottake=0+dp[ind-1][N];
        //             int rodlen=ind+1;
        //             int take=Integer.MIN_VALUE;
        //             if(rodlen<=N){
        //                 take=price[ind]+dp[ind][N-rodlen];
        //             }
        //             dp[ind][N]=Math.max(take,nottake);
              
        //       }
        //   }
        //   return dp[len-1][n];
          
          // Space optimization - tc: O(nN) sc: O(n)
          int len=price.length;
          int[] prev=new int[n+1];
          for(int i=0;i<=n;i++){
              prev[i]=i*price[0];
          }
          for(int ind=1;ind<n;ind++){
              for(int N=0;N<=n;N++){
                    int nottake=0+prev[N];
                    int rodlen=ind+1;
                    int take=Integer.MIN_VALUE;
                    if(rodlen<=N){
                        take=price[ind]+prev[N-rodlen];
                    }
                    prev[N]=Math.max(take,nottake);
              
              }
          }
          return prev[n];
        }
    }