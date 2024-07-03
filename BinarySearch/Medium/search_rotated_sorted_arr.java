// Problem link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class Solution {
    public int search(int[] nums, int target) {
        // // Brute force - tc: O(n) sc: O(1)
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target) return i;
        // }
        // return -1;

        // Optimal - tc: O(logn) sc: O(1)
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}