package Arrays.Medium;
// Problem link: https://leetcode.com/problems/rearrange-array-elements-by-sign/
class Solution {
    public int[] rearrangeArray(int[] nums) {
    // // Brute force - tc: O(n+n/2) sc: O(n)
    // int n=nums.length;
    // int[] pos=new int[n/2];
    // int[] neg=new int[n/2];
    // int k=0,p=0;
    // for(int i=0;i<n;i++){
    //     if(nums[i]>0){
    //         pos[k]=nums[i];
    //         k++;
    //     }else{
    //         neg[p]=nums[i];
    //         p++;
    //     }
    // }
    // for(int i=0;i<n/2;i++){
    //     nums[2*i]=pos[i];
    //     nums[2*i+1]=neg[i];
    // }
    // return nums;

    // Optimal - tc: O(n) sc: O(n)
    int posindex=0;
    int negindex=1;
    int [] ans = new int[nums.length];
    for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
            ans[posindex]=nums[i];
            posindex+=2;
        }else{
            ans[negindex]=nums[i];
            negindex+=2;
        }
    }
    return ans;
    }
}
