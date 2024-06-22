// Problem link: https://leetcode.com/problems/combination-sum/
class Solution {
    public void solver(int ind, int[] arr, int n, int target, List<Integer> temp, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(ind == n || target < 0){
            return;
        }
        
        temp.add(arr[ind]);
        solver(ind,arr,n,target-arr[ind],temp,ans);
        temp.remove(temp.size()-1);
        solver(ind+1, arr, n, target,temp,ans);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // tc: O(2t*k) t-> target k-> adding to ans list sc: O(k*x) k-> avg length x-> no of combs
        List<List<Integer>> ans=new ArrayList<>();
        solver(0,candidates,candidates.length,target,new ArrayList<>(),ans);
        return ans;
    }
}