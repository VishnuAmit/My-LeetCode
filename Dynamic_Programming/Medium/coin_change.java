package Dynamic_Programming.Medium;
// Problem link: https://leetcode.com/problems/coin-change/
class Solution {
    //  static int solve(int ind,int[][] dp,int target,int []nums){
    //     if(ind == 0){
    //         if(target%nums[0] == 0)return target/nums[0];
    //         else return 1000000000;
    //     }
    //     if(dp[ind][target]!= -1){
    //         return dp[ind][target];
    //     }
    //     int NotTake =0 + solve(ind-1,dp,target,nums);
    //     int Take = Integer.MAX_VALUE;
    //     if(nums[ind]<=target){
    //         Take =1+solve(ind,dp,target-nums[ind],nums);
    //     }
    //     return dp[ind][target] = Math.min(NotTake,Take);
    // }
    public int coinChange(int[] nums, int amount) {
        // // Memoization - tc: O(nt) sc: O(nt +(n+t))
        // int n = nums.length;
        // int dp[][] = new int[n][amount+1];
        // for(int row[] :dp)
        // Arrays.fill(row,-1);
        // int ans = solve(n-1,dp,amount,nums);
        // if(ans == 1000000000){
        //     return -1;
        // }
        // return ans;


        // // Tabulation - tc: O(nt) sc: O(nt)
        // int n = nums.length;
        // int dp[][] = new int[n][amount+1];

        // for (int tar = 0; tar <= amount; tar++) {
        //     if (tar % nums[0] == 0) {
        //         dp[0][tar] = tar / nums[0];
        //     } else {
        //         dp[0][tar] = 1000000000;
        //     }
        // }

        // for (int i = 1; i < n; i++) {
        //     for (int target = 0; target <= amount; target++) {
        //         int nottake = dp[i - 1][target];
        //         int take = Integer.MAX_VALUE;
        //         if (nums[i] <= target) {
        //             take = 1 + dp[i][target - nums[i]];
        //         }
        //         dp[i][target] = Math.min(take, nottake);
        //     }
        // }

        // int ans = dp[n - 1][amount];
        // if (ans >= 1000000000) {
        //     return -1;
        // }
        // return ans;

        // Space Optimization - tc: O(nt) sc: O(t)
        int n = nums.length;
        int[] prev=new int[amount+1];
        int[] cur=new int[amount+1];

        for (int tar = 0; tar <= amount; tar++) {
            if (tar % nums[0] == 0) {
                prev[tar] = tar / nums[0];
            } else {
                prev[tar] = 1000000000;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {
                int nottake = prev[target];
                int take = Integer.MAX_VALUE;
                if (nums[i] <= target) {
                    take = 1 + cur[target - nums[i]];
                }
                cur[target] = Math.min(take, nottake);
            }
            prev=cur.clone();
        }

        int ans = prev[amount];
        if (ans >= 1000000000) {
            return -1;
        }
        return ans;
    }
}