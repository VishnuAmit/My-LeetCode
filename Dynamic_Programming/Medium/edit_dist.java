package Dynamic_Programming.Medium;
// Problem link: https://leetcode.com/problems/edit-distance/
class Solution {
    // public int helper(String s1, String s2, int i, int j, int[][]dp){
    //     if(i<0) return j+1;
    //     if(j<0) return i+1;

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return dp[i][j]=helper(s1,s2,i-1,j-1,dp);
    //     }
    //     return dp[i][j]=1+Math.min(helper(s1,s2,i,j-1,dp), Math.min(helper(s1,s2,i-1,j,dp),helper(s1,s2,i-1,j-1,dp)));
    
    // }
    public int minDistance(String word1, String word2) {
        // // Memoization - tc: O(nm) sc: O(nm+(n+m))
        // int n=word1.length();
        // int m=word2.length();
        // int[][] dp=new int[n][m];
        // for(int[] rows:dp){
        //     Arrays.fill(rows,-1);
        // }
        // return helper(word1,word2, word1.length()-1,word2.length()-1,dp);

        // // Tabulation - tc: O(nm) sc: O(nm)
        // int n=word1.length();
        // int m=word2.length();
        // int[][] dp=new int[n+1][m+1];
        // for(int i=0;i<=n;i++){
        //     dp[i][0]=i;
        // }
        // for(int j=0;j<=m;j++){
        //     dp[0][j]=j;
        // }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(word1.charAt(i-1)==word2.charAt(j-1)){
        //             dp[i][j]=dp[i-1][j-1];
        //         }else{
        //             dp[i][j]=1+Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]));
        //         }
        // }
        // }
        // return dp[n][m];

        // Space optimization - tc: O(nm) sc: O(nm)
        int n=word1.length();
        int m=word2.length();
        if (n * m == 0) {
        return n + m; 
        }
        int[]prev=new int[m+1];
        int[]cur=new int[m+1];
        for(int j=0;j<=m;j++){
            prev[j]=j;
        }
        for(int i=1;i<=n;i++){
            cur[0]=i;
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cur[j]=prev[j-1];
                }else{
                    cur[j]=1+Math.min(prev[j-1], Math.min(prev[j],cur[j-1]));
                }
        }
        prev=cur.clone();
        }
        return prev[m];
    }
}