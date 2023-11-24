package Medium;
// Problem link: https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        // // Brute force - tc: O(n3) sc: O(1)
        // int max=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         int sum=0;
        //         for(int k=i;k<=j;k++){
        //             sum+=nums[k];
        //         }
        //         max=Math.max(max,sum);
        //     }
        // }
        // return max;

        // // Better - tc: O(n2) sc: O(1)
        // int max=0;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //             sum+=nums[j];
        //             max=Math.max(max,sum);
        //     }
        // }
        // return max;

        // Optimal - O(n) sc: O(1)
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
}