package Dynamic_Programming.Medium;
import java.util.Arrays;
// Problem link: https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int helper(int[] arr, int n, int ind, int prevind, int[][]dp){
        if(ind==n) return 0;
        if(dp[ind][prevind+1]!=-1){
            return dp[ind][prevind+1];
        }
        int nottake=0+helper(arr, n, ind+1, prevind, dp);
        int take=0;
        if(prevind==-1 || arr[ind]>arr[prevind]){
            take=1+helper(arr,n,ind+1,ind,dp);
        }

        dp[ind][prevind+1]=Math.max(take,nottake);
        return dp[ind][prevind+1];
    }
    public int lengthOfLIS(int[] nums) {
        // Better - tc: O(n2) sc: O(n2+n)
        int n=nums.length;
        int[][] dp = new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums,n,0,-1,dp);
    }
}