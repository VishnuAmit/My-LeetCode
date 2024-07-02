package Dynamic_Programming.Hard;
// Problem link: https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1
class Solution{
    static boolean ispalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    // static int helper(int ind, String s, int n, int[] dp){
    //     if(ind==n) return 0;
    //     int min_cuts=Integer.MAX_VALUE;
        
    //     if(dp[ind]!=-1) return dp[ind];
        
    //     for(int j=ind;j<n;j++){
    //         if(ispalindrome(ind,j,s)){
    //             int cost=1+helper(j+1,s,n,dp);
    //             min_cuts=Math.min(cost,min_cuts);
    //         }
    //     }
    //     return dp[ind]=min_cuts;
    // }
    
    static int palindromicPartition(String str)
    {
    //  // Memoization - tc: O(n2) sc: O(n)+O(n)
    //   int len=str.length();
    //   int[] dp=new int[len];
    //   Arrays.fill(dp,-1);
    //   return helper(0,str,len,dp)-1;
       
      // Tabulation - tc: O(n2) sc: O(n)
      int len=str.length();
      int[] dp=new int[len+1];
      for(int i=0;i<len;i++){
          dp[i]=0;
      }
      for(int ind=len-1;ind>=0;ind--){
          int min_cuts=Integer.MAX_VALUE;
          for(int j=ind;j<len;j++){
            if(ispalindrome(ind,j,str)){
                int cost=1+dp[j+1];
                min_cuts=Math.min(cost,min_cuts);
            }
        }
        dp[ind]=min_cuts;
      }
       return dp[0]-1;
    }
}
