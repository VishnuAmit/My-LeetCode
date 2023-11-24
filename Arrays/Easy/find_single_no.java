package Easy;
// Problem link: https://leetcode.com/problems/single-number/
class Solution {
    public int singleNumber(int[] nums) {
        // // Brute force - tc: O(n2) sc:O(1)
        // for(int i=0;i<nums.length;i++){
        //     int num=nums[i];
        //     int cnt=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[j]==num){
        //             cnt++;
        //         }
        //     }
        //     if(cnt==1) return num;
        // }
        // return -1;

        // // Better - tc: O(3n) sc: O(maxlen+1)
        // int n = nums.length;
        // if (n == 0) {
        //     return -1; 
        // }
        // int mini = nums[0];
        // int maxi = nums[0];
        // for (int i = 1; i < n; i++) {
        //     mini = Math.min(mini, nums[i]);
        //     maxi = Math.max(maxi, nums[i]);
        // }
        // int[] hash = new int[maxi - mini + 1];
        // for (int i = 0; i < n; i++) {
        //     hash[nums[i] - mini]++;
        // }
        // for (int i = 0; i < n; i++) {
        //     if (hash[nums[i] - mini] == 1) {
        //         return nums[i];
        //     }
        // }
        // return -1;

        // Optimal - tc: O(n) sc: O(1)
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        return xor;
    }
}
