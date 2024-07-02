import java.util.*;
// Problem link: https://leetcode.com/problems/subsets-ii/
class Solution {
    public void solver(int ind, int[] arr,int n,List<Integer> temp, List<List<Integer>> ans){
     // if(ind==n){
     //     ans.add(new ArrayList<>(temp));
     //     return;
     // }
     ans.add(new ArrayList<>(temp));
     for(int i=ind;i<n;i++){
         if(i!=ind && arr[i]==arr[i-1]) continue;
         // pick up
         temp.add(arr[i]);
         solver(i+1,arr,n,temp,ans);
         // notpick
         temp.remove(temp.size()-1);
         // solver(i+1,arr,n,temp,ans);
     }
     }

 public List<List<Integer>> subsetsWithDup(int[] nums) {
     // Brute force - tc: O(2^n(klogx)) sc: O(2^n*k)
     //         Arrays.sort(nums);  // Sort the array to handle duplicates
     //         List<List<Integer>> ans = new ArrayList<>();
     //         Set<List<Integer>> seen = new HashSet<>();  // To track seen subsets
             
     //         int n = nums.length;
     //         for (int i = 0; i < (1 << n); i++) {
     //             List<Integer> subset = new ArrayList<>();
     //             for (int j = 0; j < n; j++) {
     //                 if ((i & (1 << j)) != 0) {
     //                     subset.add(nums[j]);
     //                 }
     //             }
     //             // Only add the subset if it has not been seen before
     //             if (!seen.contains(subset)) {
     //                 ans.add(subset);
     //                 seen.add(subset);
     //             }
     //         }
     //         return ans;
     //     }
     // }

     // Optimal - tc: O(2^n*k) sc: O(2^n*k)
     Arrays.sort(nums);
     List<List<Integer>> ans=new ArrayList<>();
     solver(0,nums,nums.length,new ArrayList<>(),ans);
     return ans;
 }
}

