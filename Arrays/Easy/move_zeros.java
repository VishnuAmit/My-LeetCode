package Easy;
// Problem link: https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        // // Brute force - tc: O(n) sc: O(n)
        // int [] result= new int[nums.length];
        // int k=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         result[k]=nums[i];
        //         k++;
        //     }
        // }
        // int p=0;
        // for(int j=0;j<nums.length;j++){
        //     nums[j]= result[p++];
        // }

        // // Better - tc: O(x+n-x) sc: O(1)
        // int k=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0) break;
        //     else k++;
        // }
        // int j=k,i=k+1;
        // for(i=k+1;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         int temp=nums[i];
        //         nums[i]=nums[j];
        //         nums[j]=temp;
        //         j++;
        //     }
        // }

        // Optimal - tc: O(n) sc: O(1);
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for(;j<nums.length;j++){
            nums[j]=0;
        }
    }
}
