// Problem link: https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        // // Brute force - tc: O(n+m) sc: O(n+m)
        // ArrayList<Integer> ans=new ArrayList<>();
        // int i=0,j=0;
        // while(i<n && j<m){
        //     if(arr1[i]<arr2[j]){
        //         ans.add(arr1[i++]);
        //     }else{
        //         ans.add(arr2[j++]);
        //     }
        // }
        
        // while(i<n){
        //     ans.add(arr1[i++]);
        // }
        // while(j<m){
        //     ans.add(arr2[j++]);
        // }
        
        // return ans.get(k-1);
        
        // Optimal: O(log(min(n,m))) sc: O(1)
        if(n>m){
            return kthElement(arr2,arr1,m,n,k);
        }
        int low=Math.max(0,k-m),high=Math.min(k,n);
        
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=k-mid1;
            
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            
            if(mid1>0) l1=arr1[mid1-1]; 
            if(mid2>0) l2=arr2[mid2-1]; 
            if(mid1<n) r1=arr1[mid1]; 
            if(mid2<m) r2=arr2[mid2];
            
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return  0;
    }
}