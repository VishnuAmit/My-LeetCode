// Problem link: https://www.interviewbit.com/problems/allocate-books/

public class Solution {
    
    public static int helper(int[] arr, int pages){
        int curstd = 1;
        int stdhaspages = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] + stdhaspages <= pages){
                stdhaspages += arr[i];
            } else {
                curstd++;
                stdhaspages = arr[i];
            }
        }
        return curstd;
    }
    
    public int books(int[] A, int B) {
        // // Brute force - tc: O(n*(sum-max+1)) sc: O(1)
        // if(B>A.length) return -1;
        // int low=0;
        // int high=0;
        // for(int i=0;i<A.length;i++){
        //     low=Math.max(A[i],low);
        //     high+=A[i];
        // }
        
        // for(int i=low;i<=high;i++){
        //     if(helper(A,i)==B){
        //         return i;
        //     }
        // }
        // return low;
        
        // Optimal - tc: O(n*log(sum-max+1)) sc: O(1)
        if(B>A.length) return -1;
        int low=0;
        int high=0;
        for(int i=0;i<A.length;i++){
            low=Math.max(A[i],low);
            high+=A[i];
        }
        
        while(low<=high){
            int mid=(low+high)/2;
            int stds=helper(A,mid);
            if(stds>B){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
