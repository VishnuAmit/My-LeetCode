// Problem link: https://leetcode.com/problems/sliding-window-maximum/
import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // // Brute force - tc: O(n2) sc: O(1)
        // int n = nums.length;
        // if (n == 0) return new int[0]; 
        // int[] result = new int[n - k + 1];
        // for (int i = 0; i <= n - k; i++) {
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j < i + k; j++) {
        //         max = Math.max(nums[j], max);
        //     }
        //     result[i] = max;
        // }
        // return result;

        // Optimal - tc: O(2n) sc: O(k)
        int n=nums.length;
        int[] res=new int[n-k+1];
        int ind=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                res[ind++]=nums[dq.peek()];
            }
        }
        return res;
    }
}
