// Problem link: https://leetcode.com/problems/next-greater-element-ii/
import java.util.Stack;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // // Brute force - tc: O(n2) sc: O(n)
        // int n = nums.length;
        // int[] res = new int[n];
        // for (int i = 0; i < n; i++) {
        //     res[i] = -1; 
        //     for (int j = 1; j < n; j++) {
        //         int idx = (i + j) % n;
        //         if (nums[idx] > nums[i]) {
        //             res[i] = nums[idx];
        //             break;
        //         }
        //     }
        // }
        // return res;

        // Optimal - tc: O(n) sc: O(n)
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(i<n){
                if(!st.isEmpty()) res[i]=st.peek();
                else res[i]=-1;
            }
            st.push(nums[i%n]);
        }
        return res;

    }
}

