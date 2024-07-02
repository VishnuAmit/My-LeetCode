// Problem link: https://leetcode.com/problems/permutation-sequence/description/
class Solution {
    // public void swap(char[] s, int i, int j){
    //     char ch=s[i];
    //     s[i]=s[j];
    //     s[j]=ch;
    // }

    // public void solver(char[] s, int ind, List<String> res){
    //     if(ind==s.length){
    //         String str=new String(s);
    //         res.add(str);
    //         return;
    //     }
    //     for(int i=ind;i<s.length;i++){
    //         swap(s,i,ind);
    //         solver(s,ind+1,res);
    //         swap(s,i,ind);
    //     }
    // }
    public String getPermutation(int n, int k) {
        // // Brute force - tc: O(n!*n+)+O(n!logn!) sc: O(n)
        // String s="";
        // for(int i=1;i<=n;i++){
        //     s+=i;
        // }
        // ArrayList<String> ans=new ArrayList<>();
        // solver(s.toCharArray(),0,ans);
        // Collections.sort(ans);
        // return ans.get(k-1);

        // Optimal - tc: O(n2) sc: O(n)
        ArrayList<Integer> nums=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            nums.add(i);
        }
        nums.add(n);

        String ans="";
        k=k-1;
        while(true){
            ans+=nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.size()==0) break;
            k=k%fact;
            fact=fact/nums.size();
        }
        return ans;
    }
}