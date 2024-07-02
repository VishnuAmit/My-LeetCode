// Problem link: https://leetcode.com/problems/combination-sum-ii/description/
class Solution {
    //     public void solver(int ind, int[] arr, int n, int target, List<Integer> temp, Set<List<Integer>> ans){
    //     if(target==0){
    //         ans.add(new ArrayList<>(temp));
    //         return;
    //     }

    //     if(ind == n || target < 0){
    //         return;
    //     }
        
    //     temp.add(arr[ind]);
    //     solver(ind+1,arr,n,target-arr[ind],temp,ans);
    //     temp.remove(temp.size()-1);
    //     solver(ind+1, arr, n, target,temp,ans);
        
    // }

            public void optsolver(int ind, int[] arr, int n, int target, List<Integer> temp, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // if(target<0) return;

        for(int i=ind;i<n;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            temp.add(arr[i]);
            optsolver(i+1,arr,n,target-arr[i],temp,ans);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // // Brute force - tc: O(2^n*klogN) sc: O(k*x) k-> avg length x-> no of combs
        // Set<List<Integer>> ans=new HashSet<>();
        // Arrays.sort(candidates);
        // solver(0,candidates,candidates.length,target,new ArrayList<>(),ans);
        // List<List<Integer>> result=new ArrayList<>(ans);
        // return result;

        // Optimal - tc: (2^n*k+nlogn) sc: O(kx)
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        optsolver(0,candidates,candidates.length,target,new ArrayList<>(),result);
        return result;

    }
}