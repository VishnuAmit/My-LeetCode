// Problem link: https://www.geeksforgeeks.org/problems/aggressive-cows/0
class Solution {
    public static boolean isValid(int[] arr, int k, int m){
        int cows=1;
        int last=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=m){
                cows++;
                last=arr[i];
            }
            if(cows>=k) return true;
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        // // Brute force - tc: O(nlogn + n*(max-min)) sc: O(1)
        // Arrays.sort(stalls);
        // int limit=stalls[n-1]-stalls[0];
        
        // for(int i=1;i<=limit;i++){
        //     if(isValid(stalls,k,i)==false) return i-1;
        // }
        // return limit;
        
        // Optimal - tc: O(nlogn+n*(log(max-min))) sc: O(1);
        Arrays.sort(stalls);
        int low=0;
        int high=stalls[n-1]-stalls[0];
        
        while(low<=high){
            int mid=(low+high)/2;
            if(isValid(stalls,k,mid)==true){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }
}