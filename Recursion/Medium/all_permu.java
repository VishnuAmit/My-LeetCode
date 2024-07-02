// Problem link: https://leetcode.com/problems/permutations/description/
class Solution {
    // public void solver(int[]arr, boolean[] freq, List<List<Integer>> ans,List<Integer> ds){
    //     if(ds.size()==arr.length){
    //         ans.add(new ArrayList<>(ds));
    //         return;
    //     }

    //     for(int i=0;i<arr.length;i++){
    //         if(!freq[i]){
    //             freq[i]=true;
    //             ds.add(arr[i]);
    //             solver(arr,freq,ans,ds);
    //             ds.remove(ds.size()-1);
    //             freq[i]=false;
    //         }
    //     }
    // }

    public void swap(int[] arr, int i, int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public void optsolver(int ind, int[] arr, List<List<Integer>> ans){
        if(ind==arr.length){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                temp.add(arr[i]);
            }
            ans.add(arr[ind]);
        }

        for(int i=ind;i<arr.length;i++){
            swap(arr,i,ind);
            optsolver(ind+1,arr,ans);
            swap(arr,i,ind);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // // Brute force - tc: O(n!*n) sc: O(2n)
        // boolean[] freq=new boolean[nums.length];
        // List<List<Integer>> ans=new ArrayList<>();
        // solver(nums,freq,ans,new ArrayList<>());
        // return ans;

        // Optimal - tc: O(n!*n) sc: O(1)
        List<List<Integer>> ans=new ArrayList<>();
        optsolver(0,nums,ans);
        return ans;

    }
}