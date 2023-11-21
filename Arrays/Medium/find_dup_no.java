package Arrays.Medium;
// Problem link: https://leetcode.com/problems/find-the-duplicate-number/
class Solution {
    public int findDuplicate(int[] nums) {
        // // Brute force - tc: O(nlogn+n) sc: O(1)
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==nums[i+1]) return nums[i];
        // }
        // return -1;

        // // Better - O(n) sc: O(n)
        // int [] freq=new int[nums.length];
        // for(int i=0;i<freq.length;i++){
        //     if(freq[nums[i]]==0){
        //         freq[nums[i]]+=1;
        //     }else{
        //         return nums[i];
        //     }
        // }
        // return -1;

        // Optimal - tc: O(n) sc: O(1)
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
