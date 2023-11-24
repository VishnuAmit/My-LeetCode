package Medium;
import java.util.*;
// Problem link: https://leetcode.com/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // tc- O(mn) sc: O(n)-> to return ans
        ArrayList<Integer> ans=new ArrayList<>();
        int n=matrix.length,m=matrix[0].length;
        int top=0,left=0,right=m-1,bottom=n-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
