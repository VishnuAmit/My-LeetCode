// Problem link: https://www.geeksforgeeks.org/problems/subset-sums2234/1
class Solution {
    static void solver(int idx, int n, ArrayList<Integer> arr, int sum, ArrayList<Integer> ans){
        if(idx==n){
            ans.add(sum);
            return;
        }
        
        solver(idx+1,n,arr,sum+arr.get(idx),ans);
        solver(idx+1,n,arr,sum,ans);
        
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // Brute force - tc: O(2^n*n) sc: O(2^n)
        // ArrayList<Integer> ans=new ArrayList<>();
        // for(int i=0;i<(1<<n);i++){
        //     int sum=0;
        //     for(int j=0;j<n;j++){
        //         if((i & (1<<j)) !=0){
        //             sum+=arr.get(j);
        //         }
        //     }
        //     ans.add(sum);
        // }
        // return ans;
        
        // Optimal - tc: O(2^n)+O(2^nlog(2^n)) sc: O(2^n)
        ArrayList<Integer> ans=new ArrayList<>();
        solver(0,n,arr,0,ans);
        Collections.sort(ans);
        return ans;
    }
}