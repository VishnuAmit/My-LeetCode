// Problem link: https://leetcode.com/problems/largest-rectangle-in-histogram/
import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] heights) {
        // // Brute force - tc: O(n2) sc: O(1)
        // int n=heights.length;
        // int maxarea=0;
        // for(int i=0;i<n;i++){
        //     int minheight=Integer.MAX_VALUE;
        //     for(int j=i;j<n;j++){
        //         minheight=Math.min(minheight, heights[j]);
        //         maxarea=Math.max(maxarea, minheight*(j-i+1));
        //     }
        // }
        // return maxarea;

        // // Better - tc: O(4n) sc: O(3n)
        // int n=heights.length;
        // Stack<Integer> st=new Stack<>();
        // int[] leftsmall=new int[n];
        // int[] rightsmall=new int[n];
        // for(int i=0;i<n;i++){
        //     while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
        //         st.pop();
        //     }
        //     if(st.isEmpty()) leftsmall[i]=0;
        //     else leftsmall[i]=st.peek()+1;
        //     st.push(i);
        // }
        
        // while(!st.isEmpty()) st.pop();

        // for(int i=n-1;i>=0;i--){
        //     while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
        //         st.pop();
        //     }
        //     if(st.isEmpty()) rightsmall[i]=n-1;
        //     else rightsmall[i]=st.peek()-1;
        //     st.push(i);
        // }

        // int maxarea=0;
        // for(int i=0;i<n;i++){
        //     maxarea=Math.max(maxarea, heights[i]*(rightsmall[i]-leftsmall[i]+1));
        // }
        // return maxarea;

        // Optimal - tc: O(2n) sc: O(n)
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxarea=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int height=heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()) width=i;
                else width=i-st.peek()-1;
                maxarea=Math.max(maxarea,(height*width));
            }
            st.push(i);
        }
    return maxarea;
    }
}