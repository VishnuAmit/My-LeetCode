package Dynamic_Programming.Medium;
// Problem link: https://leetcode.com/problems/longest-common-subsequence/
class Solution {
    // public int helper(String s1, String s2, int ind1, int ind2,int[][]dp){
    //     if(ind1<0 || ind2<0) return 0;

    //     if(dp[ind1][ind2]!=-1){
    //         return dp[ind1][ind2];
    //     }

    //     if(s1.charAt(ind1)==s2.charAt(ind2)){
    //         return dp[ind1][ind2]=1+helper(s1,s2,ind1-1,ind2-1,dp);
    //     }

    //     return dp[ind1][ind2]=Math.max(helper(s1,s2,ind1-1,ind2,dp), helper(s1,s2,ind1,ind2-1,dp));

    // }
    public int longestCommonSubsequence(String text1, String text2) {
        // // Memoization - tc: O(nm) sc: O(nm + (n+m))
        // int s1=text1.length();
        // int s2=text2.length();
        // int[][] dp=new int[s1][s2];
        //   for (int rows[] : dp)
        //     Arrays.fill(rows, -1);

        // return helper(text1,text2,s1-1, s2-1,dp);

        // // Tabulation - tc: O(nm) sc: O(nm)
        // int n=text1.length();
        // int m=text2.length();
        // int[][] dp=new int[n+1][m+1];
        // for(int rows[]: dp){
        //     Arrays.fill(rows,-1);
        // }
        // for(int i=0;i<=n;i++){
        //     dp[i][0]=0;
        // }
        // for(int i=0;i<=m;i++){
        //     dp[0][i]=0;
        // }

        // for(int ind1=1;ind1<=n;ind1++){
        //     for(int ind2=1;ind2<=m;ind2++){
        //               if(text1.charAt(ind1-1)==text2.charAt(ind2-1)){
        //                 dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
        //               }else{
        //                  dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
        //               }
        //     }
        // }
        // return dp[n][m];

        // Space optimization - tc: O(nm) sc: O(m)
        int n = text1.length();
        int m = text2.length();
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            prev = (int[]) (cur.clone());
        }

        return prev[m]; 
    }
}