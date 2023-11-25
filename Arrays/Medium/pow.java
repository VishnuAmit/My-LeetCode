package Medium;
// Problem link: https://leetcode.com/problems/powx-n/
class Solution {
    public double myPow(double x, int n) {
        // // Brute force -  tc: O(n) sc: O(1)
        // if (n < 0) {
        //     x = 1 / x;
        //     n = -n;
        // }
        // double ans=1.0;
        // for(int i=1;i<=n;i++){
        //     ans*=x;
        // }
        // return ans;

        // Optimal - tc: O(logn) sc: O(1)
        double ans=1.0;
        long nn=n;
        if(nn<0) nn=-1*nn;
        while(nn>0){
            if(nn%2==0){
                x=x*x;
                nn=nn/2;
            }else{
                ans=ans*x;
                nn=nn-1;
            }
        }
        if(n<0) ans = (double)(1.0)/(double)ans;
        return ans;
    }
}
