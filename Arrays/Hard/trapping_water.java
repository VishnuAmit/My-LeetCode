package Hard;

// Problem link: https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        // // Brute force - tc: O(n2) sc: O(1)
        // int watertrap=0;
        // int n=height.length;
        // for(int i=0;i<n;i++){
        //     int j=i;
        //     int leftmax=0,rightmax=0;
        //     while(j>=0){
        //         leftmax=Math.max(leftmax,height[j]);
        //         j--;
        //     }
        //     j=i;
        //     while(j<n){
        //         rightmax=Math.max(rightmax,height[j]);
        //         j++;
        //     }
        //     watertrap+=Math.min(leftmax,rightmax)-height[i];
        // }
        // return watertrap;

        // // Better - tc: O(3n) sc: O(2n)
        // int n=height.length;
        // int[] presum=new int[n];
        // int[] suffsum=new int[n];
        // presum[0]=height[0];
        // suffsum[n-1]=height[n-1];
        // for(int i=1;i<n;i++){
        //     presum[i]+=Math.max(presum[i-1],height[i]);
        // }
        // for(int i=n-2;i>=0;i--){
        //     suffsum[i]+=Math.max(suffsum[i+1],height[i]);
        // }
        // int watertrap=0;
        // for(int i=0;i<n;i++){
        //     watertrap+=Math.min(presum[i],suffsum[i])-height[i];
        // }
        // return watertrap;

        // Optimal - 
        int n=height.length;
        int left=0,right=n-1,leftmax=0,rightmax=0;
        int res=0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftmax) leftmax=height[left];
                else{
                    res+=leftmax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightmax) rightmax=height[right];
                else{
                    res+=rightmax-height[right];
                }
                right--;
            }
        }
        return res;
    }
}