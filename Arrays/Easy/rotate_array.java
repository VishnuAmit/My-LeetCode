package Easy;
// Problem link: https://leetcode.com/problems/rotate-array/
class Solution {
    public void reverse(int start, int end, int arr[]){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        // // Brute force - tc: O(n+d) sc: O(d)
        // int n=nums.length;
        // k=k%n;
        // int [] temp=new int[nums.length];
        // for(int i=n-k;i<n;i++){
        //     temp[i-n+k]=nums[i];
        // }
        // for(int i=n-k-1;i>=0;i--){
        //     nums[i+k]=nums[i];
        // }
        // for(int i=0;i<k;i++){
        //     nums[i]=temp[i];
        // }

        // Optimal : tc: O(n) sc: O(1)
        int n=nums.length;
        k=k%n;
        reverse(0,n-k-1,nums);
        reverse(n-k,n-1,nums);
        reverse(0,n-1,nums);
    }
}

