package Medium;
// Problem link: https://leetcode.com/problems/next-permutation/
class Solution {
    public void reverse(int start,int end, int arr[]){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
    // // Optimal - tc: O(3n) sc: O(1)
     int n=nums.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind == -1){
            reverse(0,n-1,nums);
        }else{
        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
            }
        reverse(ind+1,n-1,nums);
        }


    }
}
