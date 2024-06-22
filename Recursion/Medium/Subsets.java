// Problem link: https://leetcode.com/problems/subsets/
class Solution {
    public void solve(int idx, int[] arr, List<Integer> temp,int n, List<List<Integer>> ans){
        if(idx==n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr[idx]);
        solve(idx+1,arr,temp,n,ans);
        temp.remove(temp.size()-1);
        solve(idx+1,arr,temp,n,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        // Brute force - tc: O(2^n*n) sc: O(2^n) 
        // List<List<Integer>> ans=new ArrayList<>();
        // int n=nums.length;
        // for(int i=0;i<(1<<n);i++){
        //     List<Integer> subset=new ArrayList<>();
        //     for(int j=0;j<n;j++){
        //         if((i & (1<<j))!=0){
        //             subset.add(nums[j]);
        //         }
        //     }
        //     ans.add(subset);
        // }
        // return ans;

          // Optimal - tc: O(2^n) sc: O(2^n)
          List<List<Integer>> ans=new ArrayList<>();
          solve(0,nums,new ArrayList<>(),nums.length,ans);
          return ans;
    }
}