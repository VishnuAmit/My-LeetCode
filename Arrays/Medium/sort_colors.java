package Medium;
// Problem link: https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        // // Brute force - O(nlogn) sc: O(1)
        // Arrays.sort(nums);

        // // Better - tc: O(2n) sc: O(1) 
        // int cnt0=0,cnt1=0,cnt2=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0) cnt0++;
        //     else if(nums[i]==1) cnt1++;
        //     else cnt2++;
        // }
        // for(int i=0;i<cnt0;i++){
        //     nums[i]=0;
        // }
        // for(int i=cnt0;i<cnt0+cnt1;i++){
        //     nums[i]=1;
        // }
        // for(int i=cnt0+cnt1;i<nums.length;i++){
        //     nums[i]=2;
        // }

        // Optimal - O(n) sc: O(1)
        int n=nums.length;
        int low=0,mid=0,high=n-1;
        while(mid<=high){
           if(nums[mid]==0){
               int temp=nums[low];
               nums[low]=nums[mid];
               nums[mid]=temp;
               low++;
               mid++;
           }else if(nums[mid]==1) mid++;
           else{
                int temp=nums[mid];
               nums[mid]=nums[high];
               nums[high]=temp;
               high--;
           }
        }
    }
}
