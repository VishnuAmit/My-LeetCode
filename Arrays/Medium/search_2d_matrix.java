package Medium;
// Problem link: https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // // Brute force - tc: O(nm) sc: O(1);
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]==target) return true;
        //     }
        // }
        // return false;

        // Optimal - tc: O(log(mn)) sc: O(1)
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0,high=(n*m)-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(matrix[mid/m][mid%m]==target) return true;
            else if(matrix[mid/m][mid%m]>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}