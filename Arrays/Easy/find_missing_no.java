package Easy;
// Problem link: https://leetcode.com/problems/missing-number/
class Solution {
    public int missingNumber(int[] nums) {
    // // Brute force - tc: O(n2) sc: O(1)
    // for(int i=0;i<nums.length+1;i++){
    //     int flag=0;
    //     for(int j=0;j<nums.length;j++){
    //         if(nums[j]==i){
    //             flag=1;
    //             break;
    //             }
    //         }
    //         if(flag==0) return i;
    //     }
    //     return -1;

    // // Better - tc: O(2n) sc: O(n)
    // int [] freq=new int[nums.length+1];
    // for(int i=0;i<nums.length;i++){
    //     freq[nums[i]]++;
    // }
    // for(int i=0;i<=nums.length;i++){
    //     if(freq[i]==0){
    //         return i;
    //     }
    // }
    // return -1;

    // Optimal - tc: O(n) sc: O(1);
        int n=nums.length;
        int S=n*(n+1)/2;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return S-sum;
    }
}
