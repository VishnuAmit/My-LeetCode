package Medium;
// Problem link: https://leetcode.com/problems/maximum-product-subarray/
class Solution {
    public int maxProduct(int[] nums) {
    //   // Brute force - tc: O(n3) sc: O(1)
    //   int fin=Integer.MIN_VALUE;
    //   int n=nums.length;
    //   for(int i=0;i<n;i++){
    //       for(int j=i;j<n;j++){
    //           int prod=1;
    //           for(int k=i;k<=j;k++){
    //               prod*=nums[k];
    //           }
    //           fin=Math.max(fin,prod);
    //       }
    //   }
    //   return fin;

    // // Better - tc: O(n2) sc: O(1)
    //   int fin=Integer.MIN_VALUE;
    //   int n=nums.length;
    //   for(int i=0;i<n;i++){
    //     int prod=1;
    //       for(int j=i;j<n;j++){
    //               prod*=nums[j];
    //             fin=Math.max(fin,prod);
    //       }
    //   }
    //   return fin;

    // Optimal - tc: O(n) sc: O(1)
    int pre=1,suff=1;
    int max=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++){
        if(pre==0) pre=1;
        if(suff==0) suff=1;
        pre*=nums[i];
        suff*=nums[nums.length-i-1];
        max=Math.max(max,Math.max(pre,suff));
    }
    return max;
    }
}
