package Arrays.Easy;
import java.util.ArrayList;
import java.util.Collections;
// Problem link: https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
class Solution{
    static ArrayList<Integer> leaders(int arr[], int n){
        // // Brute force - tc: O(n2) sc: O(n) -> to return the ans
        // ArrayList<Integer> ans=new ArrayList<>();
        // for(int i=0;i<arr.length;i++){
        //     boolean flag=true;
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[j]>arr[i]){
        //             flag=false;
        //             break;
        //         }
        //     }
        //     if(flag){
        //         ans.add(arr[i]);
        //     }
        // }
        // return ans;
        
        // Optimal - O(n) sc: O(n) -> for ans
        ArrayList<Integer> ans=new ArrayList<>();
        int maxr=arr[n-1];
        ans.add(arr[n-1]);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>maxr){
                ans.add(arr[i]);
                maxr=arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}

