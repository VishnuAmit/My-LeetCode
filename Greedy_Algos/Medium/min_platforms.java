package Greedy_Algos.Medium;
import java.util.Arrays;
// Prbolem link: https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
class Solution
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        // // Brute force - tc: O(n2) sc: O(1);
        // int n=arr.length;
        // int maxcnt=0;
        // for(int i=0;i<n;i++){
        //     int cnt=0;
        //     for(int j=0;j<n;j++){
        //         if(arr[i]>=arr[j] && arr[i]<=dep[j]) cnt++;
        //     }
        //     maxcnt=Math.max(cnt,maxcnt);
        // }
        // return maxcnt;

        
        // Optimal - tc: O(2nlogn + 2n) sc: O(1)
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0;
        int plat=1,res=1;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                plat++;
                i++;
            }
            else if(arr[i]> dep[j]){
                plat--;
                j++;
            }
            res=Math.max(plat,res);
        }
        return res;
    }
    
}
