// Problem link: https://leetcode.com/problems/word-break/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // // Brute force - tc: O(2^n) sc: O(2^n)
        // int n=s.length();
        // int pos=0;
        // if(pos==n) return true;
        // ArrayList<String> ans=new ArrayList<>(wordDict);
        // for(int i=pos;i<n;i++){
        //     if(ans.contains(s.substring(pos,i+1))){
        //         if(wordBreak(s.substring(i+1,n),ans)) return true;
        //     }
        // }
        // return false;

        // Optimal - tc: O(nm) sc: O(n)
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp,false);
        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--){
            for(String word : wordDict){
                if(((i + word.length()) <= s.length()) && (s.substring(i, i + word.length()).startsWith(word))){
                    dp[i] = dp[i + word.length()];
                }
                if(dp[i]==true)
                    break;
            }
        }
        return dp[0];

    }
}