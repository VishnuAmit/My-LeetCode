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

    public int partition(int []arr, int left, int right){
        int pivot=arr[left];
        int l=left+1;
        int r=right;

        while(l<=r){
            if(arr[l]<pivot && arr[r]>pivot){
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
            if(arr[l]>=pivot){
                l++;
            }
            if(arr[r]<=pivot){
                r--;
            }
        }
        int temp2=arr[left];
        arr[left]=arr[r];
        arr[r]=temp2;

        return r;
    }

    public int findKthLargest(int[] nums, int k) {
        // // Brute force - O(nlogn) sc: O(1)
        // int n=nums.length;
        // Arrays.sort(nums);
        // return nums[n-k];

        // // Better - tc: O(k+(n-k)*log(k)) sc: O(k)
        // return max_heap(nums,k);

        // Optimal - O(n) sc: O(1)
        int left=0, right=nums.length-1, kth;
        while(true){
            int index=partition(nums,left,right);
            if(index==k-1){
                kth=nums[index];
                break;
            }else if(index<k-1){
                left=index+1;
            }else{
                right=index-1;
            }
        }
        return kth;
    }
}