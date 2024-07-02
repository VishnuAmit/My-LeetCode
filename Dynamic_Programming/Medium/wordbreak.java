package Dynamic_Programming.Medium;
import java.util.List;
// Problem link: https://leetcode.com/problems/word-break/description/
class Solution {
    // private boolean helper(String s, int ind, List<String> wordDict, boolean[] dp){
    //     if(ind==s.length()) return true;
    //     if(dp[ind]){
    //         return true;
    //     }
    //     for(int i=ind;i<s.length();i++){
    //         String mystr=s.substring(ind,i+1);
    //         if(wordDict.contains(mystr) && helper(s,i+1,wordDict,dp)){
    //             return dp[ind]=true;
    //         }
    //     }
    //     return dp[ind]=false;
    // }

    public boolean wordBreak(String s, List<String> wordDict) {
        // // Memoization - tc: O(n2) sc: O(n+n)
        // int n=s.length();
        // boolean[] dp=new boolean[n+1];
        // Arrays.fill(dp,false);
        // return helper(s,0,wordDict,dp);

        // Tabulation - tc: tc: O(n2) sc: O(n)
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
        }
    }

    return dp[n];
    }
}