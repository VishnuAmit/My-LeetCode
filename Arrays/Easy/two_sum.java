package Easy;

import java.util.Arrays;

// Problem link: https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // Brute force - tc: O(n2) sc: O(1)
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[] {i,j};
        //         }
        //     }
        // }
        // throw new IllegalArgumentException("No two sum solution");

        // // Better - tc: O(nlogn) sc: O(n)
        // HashMap<Integer,Integer> mpp=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     int num=nums[i];
        //     int more = target-nums[i];
        //     if(mpp.containsKey(more)){
        //         return new int[] {mpp.get(more),i};
        //     }else{
        //         mpp.put(nums[i],i);
        //     }
        // }
        // throw new IllegalArgumentException("No two sum solution");

        // Optimal - tc: O(n + n log n) sc: O(1)
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int sum = sortedNums[left] + sortedNums[right];
            if (sum == target) {
                // Find indices of the sorted values in the original array
                int index1 = -1, index2 = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == sortedNums[left]) {
                        index1 = i;
                        break;
                    }
                }
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (nums[i] == sortedNums[right]) {
                        index2 = i;
                        break;
                    }
                }
                return new int[] { index1, index2 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
