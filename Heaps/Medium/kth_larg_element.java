// Problem link: https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    // public int max_heap(int [] arr, int k){
    //     PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         pq.add(arr[i]);
    //     }
    //     int rem=k-1;
    //     while(rem>0){
    //         pq.remove();
    //         rem--;
    //     }
    //     return pq.peek();
    // }

    public int quickselect(int[] nums, int l, int r){
        int pivot=nums[r];
        int p=l;
        for(int i=l;i<r;i++){
            if(nums[i]<=pivot){
                int temp=nums[i];
                nums[i]=nums[p];
                nums[p]=temp;
                p++;
            }
        }
        int temp1=nums[p];
        nums[p]=nums[r];
        nums[r]=temp1;
        return p;
    }

    public int findKthLargest(int[] nums, int k) {
        // // Brute force - O(nlogn) sc: O(1)
        // int n=nums.length;
        // Arrays.sort(nums);
        // return nums[n-k];

        // // Better - tc: O(k+(n-k)*log(k)) sc: O(k)
        // return max_heap(nums,k);

        // Optimal - O(n) sc: O(1)
        int left = 0;
        int right = nums.length - 1;
    
        // Convert kth largest to kth smallest index
        int kSmallestIndex = nums.length - k;
    
        while (left <= right) {
            int index = quickselect(nums, left, right);
    
            if (index == kSmallestIndex) {
                return nums[index];  // Found the kth largest element
            } else if (index < kSmallestIndex) {
                left = index + 1;  // Search in the right part
            } else {
                right = index - 1;  // Search in the left part
            }
        }
            return Integer.MAX_VALUE; 
    }
}