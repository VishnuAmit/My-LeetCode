package Medium;
// Problem link: https://leetcode.com/problems/rotate-image/
class Solution {
    public void rotate(int[][] matrix) {
        // // Brute force - tc: O(n2) sc: O(n2)
        // int n=matrix.length;
        // int m=matrix[0].length;
        // int[][] rotated = new int[n][m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         rotated[j][n-1-i]=matrix[i][j];
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         matrix[i][j]=rotated[i][j];
        //     }
        // }

        // Optimal - O(n2+n2) sc: O(1)
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }

    }
}