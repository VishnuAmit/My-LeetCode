package Medium;

// Problem link: https://leetcode.com/problems/set-matrix-zeroes/
class Solution {
    public void markrow(int[][] matrix, int n,int m, int i){
        for(int j=0;j<m;j++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }
        }
    }
    public void markcol(int[][] matrix, int n,int m, int j){
        for(int i=0;i<n;i++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        // // Brute force - tc: O((nm)(n + m)) + O(nm) sc: O(1)
        // int n=matrix.length;
        // int m=matrix[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j]==0){
        //             markrow(matrix,n,m,i);
        //             markcol(matrix,n,m,j);
        //         }
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j]==-1){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }

        // // Better - tc: O(2nm) sc: O(n+m)
        // int n=matrix.length;
        // int m=matrix[0].length;
        // int[] row = new int[n];
        // int[] col = new int[m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j]==0){
        //             row[i]=1;
        //             col[j]=1;
        //         }
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(row[i]==1 || col[j]==1){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }

        // Optimal - tc: O(2nm) sc: O(1) 
        int n = matrix.length;
        int m = matrix[0].length;
        int col0=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j==0){
                        col0=0;
                    }else{
                        matrix[0][j]=0;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
     
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }

    }
}