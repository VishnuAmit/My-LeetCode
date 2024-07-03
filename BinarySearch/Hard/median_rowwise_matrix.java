// Problem link: https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
class Solution {
    public static int countlessthanequalto(int[] row,int val){
        int low=0;
        int high=row.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(row[mid]<=val){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    int median(int matrix[][], int R, int C) {
        // // Brute force - tc: o(nm+(mn)log(nm)) sc: O(nm)
        // int[] res=new int[R*C];
        // int k=0;
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         res[k++]=matrix[i][j];
        //     }
        // }
        // Arrays.sort(res);
        // return res[res.length/2];
        
        // Optimal: tc: O(log(10^9)) X O(M(logN)) sc: O(1)
        int low=0;
        int high=1000000;
        int n=matrix.length;
        int m=matrix[0].length;
        while(low<=high){
            int mid=(low+high)/2;
            int cnt=0;
            for(int i=0;i<n;i++){
                cnt+=countlessthanequalto(matrix[i],mid);
            }
            if(cnt<=(n*m)/2) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}