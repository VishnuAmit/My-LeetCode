package Graphs.Easy;
import java.util.*;
// Problem link: https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
            // // Brute force - tc: 
            // for (int i = 0; i <= n - k; i++) { 
            //     int cnt = 0; 
            //     for (int j = i; j < i + k; j++) { 
            //         boolean isDistinct = true;
            //         for (int l = i; l < j; l++) {
            //             if (A[j] == A[l]) { 
            //                 isDistinct = false;
            //                 break;
            //             }
            //         }
            //         if (isDistinct) {
            //             cnt++;
            //         }
            //     }
            //     ans.add(cnt); 
            // }
            // return ans;
            
            // Optimal - tc: O(n) sc: O(n+k)
            HashMap<Integer, Integer> mpp=new HashMap<>();
            ArrayList<Integer> ans=new ArrayList<>();
            
            for(int i=0;i<k;i++){
                mpp.put(A[i], mpp.getOrDefault(A[i],0)+1);
            }
            
            ans.add(mpp.size());
            
            for(int i=k;i<n;i++){
                if(mpp.get(A[i-k])==1){
                    mpp.remove(A[i-k]);
                }
                else{
                    mpp.put(A[i-k],mpp.get(A[i-k])-1);
                }
                 mpp.put(A[i], mpp.getOrDefault(A[i],0)+1);
                ans.add(mpp.size());
            }
       return ans;
    }
}

