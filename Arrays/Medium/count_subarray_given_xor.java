package Medium;
// Problem link: https://www.codingninjas.com/codestudio/problems/subarrays-with-xor-k_6826258?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.HashMap;class Solution {
    public static int subarraysWithSumK(int []a, int b) {
    //  // Brute force - tc: O(n3) sc: O(1)
    //  int n=a.length;
    //  int cnt=0;
    //  for(int i=0;i<n;i++){
    //      for(int j=i;j<n;j++){
    //          int xor=0;
    //          for(int p=i;p<=j;p++){
    //              xor=xor^a[p];
    //          }
    //          if(xor==b){
    //              cnt++;
    //          }
    //      }
    //  }
    //  return cnt;

    //  // Better - tc: O(n2) sc: O(1)
    //  int n=a.length;
    //  int cnt=0;
    //  for(int i=0;i<n;i++){
    //     int xor=0;
    //      for(int j=i;j<n;j++){
    //         xor=xor^a[j];
    //         if(xor==b){
    //              cnt++;
    //         }
    //      }
    //  }
    //  return cnt;

    // Optimal - tc: O(nlogn) sc: O(n)
    HashMap<Integer,Integer> mpp=new HashMap<>();
    int xr=0;
    mpp.put(0,1);
    int cnt=0;
    for(int i=0;i<a.length;i++){
        xr=xr^a[i];
        int x=xr^b;
        if(mpp.containsKey(x)){
            cnt+=mpp.get(x);
        }
        if(mpp.containsKey(xr)){
            mpp.put(xr,mpp.get(xr)+1);
        }
        else{
            mpp.put(xr,1);
        }
    }
    return cnt;
    }
}
