package Dynamic_Programming.Hard;
// Problem link: https://leetcode.com/problems/super-egg-drop/
class Solution {
    // public int helper(int k, int n, int[][] dp){
    //     if(n==0 || n==1) return n;
    //     if(k==1) return n;
    //     int ans=Integer.MAX_VALUE;
    //     if(dp[k][n]!=-1){
    //         return dp[k][n];
    //     }
    //     for(int i=1;i<=n;i++){
    //         int cnt=1+Math.max(helper(k-1,i-1,dp), helper(k,n-i,dp));
    //         ans=Math.min(cnt,ans);
    //     }
    //     return dp[k][n]=ans;

    // }

    // public int helper(int k, int n, int[][] dp){
    //     if(n==0 || n==1) return n;
    //     if(k==1) return n;
    //     int ans=Integer.MAX_VALUE;
    //     int low=1,high=n;
    //     if(dp[k][n]!=-1){
    //         return dp[k][n];
    //     }
    //     while(low<=high){
    //         int mid=low+(high-low)/2;
    //         int left=helper(k-1,mid-1,dp);
    //         int right=helper(k,n-mid,dp);
    //         int cnt=1+Math.max(left,right);
    //         if(left<right){
    //             low=mid+1;
    //         }else{
    //             high=mid-1;
    //         }
    //         ans=Math.min(cnt,ans);
    //     }
    //     return dp[k][n]=ans;
    // }


    public int superEggDrop(int k, int n) {
        // // Memoization - tc: O(n2*k) sc: O(nk + k)
        // int[][] dp=new int[k+1][n+1];
        // for(int rows[]: dp){
        //     Arrays.fill(rows,-1);
        // }
        // return helper(k,n,dp);   

        // // Memoization(Optimized)- tc: O(nk*logn) sc: O(nk + k)
        // int[][] dp=new int[k+1][n+1];
        // for(int rows[]: dp){
        //     Arrays.fill(rows,-1);
        // }
        // return helper(k,n,dp);   

        // Tabulation - tc: O(nk*logn) sc: O(nk)
        int[][] dp=new int[k+1][n+1];
        if(n==0 || n==1) return n;
        if(k==1) return n;
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
            dp[1][i]=i;
        }
        for(int i=0;i<=k;i++){
            dp[i][0]=0;
            dp[i][1]=1;
        }

        for(int i=2;i<k+1;i++){
            for(int j=2;j<n+1;j++){
                 int low=1,high=j, ans=Integer.MAX_VALUE;
                   while(low<=high){
                        int mid=low+(high-low)/2;
                        int left=dp[i-1][mid-1];
                        int right=dp[i][j-mid];
                        int cnt=1+Math.max(left,right);
                        if(left<right){
                            low=mid+1;
                        }else{
                            high=mid-1;
                        }
                        ans=Math.min(cnt,ans);
                    }
                    dp[i][j]=ans;
            }
        }
    return dp[k][n];
    }
}
