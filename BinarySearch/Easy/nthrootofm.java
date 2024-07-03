// Problem link: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution {

    // public static long helper(int b, int exp){
    //     double res=1.0;
    //     long exp1=exp;
    //     if(exp<0){
    //         exp=-1*exp;
    //     }
        
    //     while(exp>0){
    //         if(exp%2==1){
    //             res=res*b;
    //             exp--;
    //         }else{
    //             exp=exp/2;
    //             b=b*b;
    //         }
    //     }
    //     if(exp<0){
    //         res=(double)1.0/res;
    //     }
    //     return (long)res;
    // }
    
    public static long helper(int mid, int n, int m){
        double res=1.0;
        for(int i=1;i<=n;i++){
            res=res*mid;
             if(res>m) return 2;
        }
      
        if(res==m) return 1;
        else return 0;
    }
    public int NthRoot(int n, int m) {
        // // Brute force - O(m*logn) sc: O(1)
        // for (int i = 0; i <= m; i++) {
        //     long val = helper(i,n);
        //     if(val==(long)m) return i;
        //     else if(val>(long)m) break;
        // }
        // return -1;
        
        // Optimal - tc: )(logm + n) sc: O(1)
        
        int low=1;
        int high=m;
        while(low<=high){
            int mid=(low+high)/2;
            long target=helper(mid,n,m);
            if(target==1) return mid;
            else if(target==0) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}