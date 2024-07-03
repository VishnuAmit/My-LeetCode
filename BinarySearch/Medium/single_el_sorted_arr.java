// Problem link: https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Brute force - tc: O(2n) sc: O(n)
        // HashMap<Integer,Integer> mpp=new HashMap<>();
        // for(int num:nums){
        //     mpp.put(num,mpp.getOrDefault(num,0)+1);
        // }

        // for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
        //     if(entry.getValue()==1){
        //         return entry.getKey();
        //     }
        // }
        // return -1;

        // Better - tc: O(n) sc: O(1)
        // int res=0;
        // for(int i=0;i<nums.length;i++){
        //     res=res^nums[i];
        // }
        // return res;

        // Optimal - tc: O(logn) sc: O(1)
        int n=nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        int low=1,high=n-2;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            else if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}