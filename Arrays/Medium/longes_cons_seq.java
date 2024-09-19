package Medium;
// Problem link: https://leetcode.com/problems/longest-consecutive-sequence/solution/
import java.util.*;
class Solution {
    // public boolean linearsearch(int[] arr, int x){
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]==x) return true;
    //     }
    //     return false;
    // }
    public int longestConsecutive(int[] nums) {
    // // Brute force - tc: O(n2) sc: O(1)
    //     if(nums.length==0) return 0;
    //     int longest=1;
    //     for(int i=0;i<nums.length;i++){
    //         int cnt=1;
    //         int x=nums[i];
    //         while(linearsearch(nums,x+1)==true){
    //             x=x+1;
    //             cnt++;
    //         }
    //         longest=Math.max(longest,cnt);
    //     }
    //     return longest;

    // // Better - tc: O(nlogn +n) sc: O(1)
    //     Arrays.sort(nums);
    //     int last_smallest=Integer.MIN_VALUE;
    //     int longest=0;
    //     int cnt=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i]-1==last_smallest){
    //             cnt+=1;
    //             last_smallest=nums[i];
    //         }else if(last_smallest!=nums[i]){
    //             cnt=1;
    //             last_smallest=nums[i];
    //         }
    //         longest=Math.max(longest,cnt);
    //     }
    //     return longest;

    // Optimal - O(3n) sc: O(n)
    HashSet<Integer> set = new HashSet<>();
    for(int num:nums){
        set.add(num);
    }
    int long_streak=0;
    int cur_streak=0;
    for(int num : nums){
        if(!set.contains(num-1)){
            int cur_num=num;
            cur_streak=1;
            while(set.contains(cur_num+1)){
                cur_num+=1;
                cur_streak+=1;
            }
        }
        long_streak=Math.max(long_streak,cur_streak);
    }

    return long_streak;
    
    }
}
