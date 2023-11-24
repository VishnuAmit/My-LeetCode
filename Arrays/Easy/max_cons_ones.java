package Easy;
// Problem link: https://leetcode.com/problems/max-consecutive-ones/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Brute force - tc: O(n) sc: O(1)
        // int cnt=0;
        // int maxcnt=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==1){
        //         cnt++;
        //     }else{
        //         cnt=0;
        //     }
        //     maxcnt=Math.max(maxcnt,cnt);
        // }
        // return maxcnt;

        // Better -  tc: O(n) sc: O(1)
        int cnt=0;
        int maxcnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
            }else{
                cnt=0;
                maxcnt=Math.max(maxcnt,cnt);
            }
            maxcnt=Math.max(maxcnt,cnt);
        }
        return maxcnt;
    }
}
