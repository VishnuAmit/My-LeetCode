package Dynamic_Programming.Medium;
// Problem link: https://leetcode.com/problems/partition-equal-subset-sum/
class Solution {
    // public boolean helper(int[] arr, int ind, int target, int[][]dp){
    //     if(target==0) return true;
    //     if(ind==0){
    //         return arr[0]==target;
    //     }
    //     if(dp[ind][target]!=-1){
    //         return dp[ind][target]==0 ? false:true;
    //     }
    //     boolean nottake=helper(arr,ind-1,target,dp);
    //     boolean take=false;
    //     if(arr[ind]<=target){
    //         take=helper(arr,ind-1,target-arr[ind],dp);
    //     }
    //     dp[ind][target]=take || nottake ? 1:0;
    //     return take || nottake;
    // }
    public boolean canPartition(int[] nums) {
        // // Memoization - tc: O(nt) sc: O(nt+(n))
        // int sum=0;
        // for(int num:nums){
        //     sum+=num;
        // }
        // int n=nums.length;
        // int[][] dp=new int[n][sum/2+1];
        // for(int[] rows:dp){
        //     Arrays.fill(rows,-1);
        // }
        // if (sum % 2 == 0) {
        //     return helper(nums, nums.length - 1, sum / 2,dp);
        // } else {
        //     return false;
        // }

        // // Tabulation - tc: O(nt) sc: O(nt)
        // int sum=0;
        // for(int num:nums){
        //     sum+=num;
        // }
        // int n=nums.length;
        // boolean[][] dp=new boolean[n][sum/2+1];
        // for(int i=0;i<n;i++){
        //     dp[i][0]=true;
        // }
        // if(nums[0]<=sum/2){
        //     dp[0][nums[0]]=true;
        // }
        // for(int ind=1;ind<n;ind++){
        //     for(int tar=1;tar<=sum/2;tar++){
        //         boolean nottake= dp[ind-1][tar];
        //         boolean take=false;
        //         if(nums[ind]<=tar){
        //             take=dp[ind-1][tar-nums[ind]];
        //         }
        //         dp[ind][tar]=take || nottake;
        //     }
        // }
        // if(sum%2 != 0) return false;
        // return dp[n-1][sum/2];

        // Space Optimization - tc: O(nt) sc: O(t)
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int n=nums.length;
        boolean[] prev =new boolean[sum/2+1];
        boolean[] cur =new boolean[sum/2+1];
        
        prev[0]=true;

        if(nums[0]<=sum/2){
            prev[nums[0]]=true;
        }
        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=sum/2;tar++){
                boolean nottake=prev[tar];
                boolean take=false;
                if(nums[ind]<=tar){
                    take=prev[tar-nums[ind]];
                }
                cur[tar]=take || nottake;
            }
            prev=cur.clone();
        }
        if(sum%2 != 0) return false;
        return prev[sum/2];
    }
}