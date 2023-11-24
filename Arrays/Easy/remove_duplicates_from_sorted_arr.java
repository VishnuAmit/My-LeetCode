package Easy;
// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        // // Brute force - tc: O(nlogn+n) sc: O(n)
        // int k=0;
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     if(!set.contains(nums[i])){
        //         nums[k]=nums[i];
        //         set.add(nums[i]);
        //         k++;
        //     };
        // }
        // return set.size();

        // Optimal - tc: O(n) sc: O(1)
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}
