package Medium;
// Problem link: https://www.codingninjas.com/codestudio/problems/missing-and-repeating-numbers_6828164?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
    //    // Brute force - tc: O(n2) sc: O(1)
    //    int rep=-1,miss=-1;
    //    int n=a.length;
    //    for(int i=1;i<=n;i++){
    //        int cnt=0;
    //        for(int j=0;j<n;j++){
    //            if(a[j]==i) cnt++;
    //            }
    //             if(cnt==2) rep=i;
    //             else if(cnt==0) miss=i;
    //             if(rep!=-1 && miss!=-1){
    //                break;
    //        }
    //    }
    //    int[] ans = {rep,miss};
    //    return ans;

    //     // Better - tc: O(2n) sc: O(n) 
    //     int n=a.length; 
    //     int [] hash=new int[n+1];
    //     for(int i=0;i<n;i++){
    //         hash[a[i]]++;
    //     }
    //     int rep=-1,miss=-1;
    //     for(int i=1;i<=n;i++){
    //         if(hash[i]==2) rep=i;
    //         else if(hash[i]==0) miss=i;
    //         if(rep!=-1 && miss!=-1){
    //                break;
    //        }
    //    }
    //    int[] ans = {rep,miss};
    //    return ans;

    // Optimal tc: O(n) sc: O(1)
    long n=a.length; 
    long sn=(n*(n+1))/2;
    long s2n = (n * (n + 1) * (2 * n + 1)) / 6;
    long s1 = 0, s2 = 0; 
    for (int i = 0; i < n; i++) {
            s1 += a[i];
            s2 += (long) a[i] * (long) a[i];
    }
    long val1=s1-sn; // x-y
    long val2=s2-s2n; 
    val2=val2/val1;
    long x=(val1+val2)/2;
    long y=x-val1;
    int[] ans = {(int)x, (int)y};
    return ans;
                  
    }
}
