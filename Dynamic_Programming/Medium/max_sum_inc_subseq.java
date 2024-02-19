package Dynamic_Programming.Medium;
// Problem link: https://www.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
class Solution{
    // public static int totwt;
    
    // public int helper(int[] arr, int n, int[] dp){
    //     if(n==0) return 0;
    //     int curwt=arr[n-1];
    //     if(dp[n-1]!=-1){
    //         return dp[n-1];
    //     }
    //     for(int i=1;i<n;i++){
    //         int temp=helper(arr,i,dp);
    //         if(arr[i-1]<arr[n-1] && temp+arr[n-1]>curwt){
    //             curwt=temp+arr[n-1];
    //         }
    //     }
    //     dp[n-1]=curwt;
    //     if(curwt>totwt){
    //         totwt=curwt;
    //     }
    //     return curwt;
    // }
	public int maxSumIS(int arr[], int n)  
	{  
	   //// Memoization - tc: O(n2) sc: O(n+n)
	   //if(n==1) return arr[n-1];
	   //totwt = Integer.MIN_VALUE;  
	   //int[] dp=new int[n];
	   //Arrays.fill(dp,-1);
	   //helper(arr,n,dp);
	   //return totwt;
	   
	   // Tabultion - tc: O(n2) sc: O(n)
	    int[] dp = new int[n];
        int totalWeight = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
        {
            dp[i] = arr[i];
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) 
                {
                    dp[i] = dp[j] + arr[i];
                }
            }
            totalWeight = Math.max(totalWeight, dp[i]);
        }

        return totalWeight;
	}  
}