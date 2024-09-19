package Medium;
import java.util.*;
// Problem link: https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        // // Brute force - tc: O(n3) sc: O(1)
        // int cnt=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         int sum=0;
        //         for(int p=i;p<=j;p++){
        //             sum+=nums[p];
        //         }
        //         if(sum==k){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;

        // // Better - tc: O(n2) sc: O(1)
        // int cnt=0;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //         if(sum==k){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;

        // Optimal - tc: O(nlogn) sc: O(n)
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int presum=0,cnt=0;
        mpp.put(0,1);
        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            int rem=presum-k;
            cnt+=mpp.getOrDefault(rem,0);
            mpp.put(presum,mpp.getOrDefault(presum,0)+1);
        }
        return cnt;
    }
}
