// Problem link: https://leetcode.com/problems/palindrome-partitioning/description/
class Solution {
    public static boolean ispalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }

    public void solver(String s, int ind, List<String> temp, List<List<String>> ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=ind;i<s.length();i++){
            if(ispalindrome(s,ind,i)){
                temp.add(s.substring(ind,i+1));
                solver(s,i+1,temp,ans);
                temp.remove(temp.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        // tc: O(2^n*k*n/2) sc: O(kx)
        List<List<String>> ans=new ArrayList<>();
        solver(s,0,new ArrayList<>(),ans);
        return ans;
    }
}