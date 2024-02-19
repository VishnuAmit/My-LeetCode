package Dynamic_Programming.Medium;
import java.util.ArrayList;
// Problem link: https://bit.ly/3FvHbMO
class Solution {

	// public static int knapsack(ArrayList<Integer> values, ArrayList<Integer> weights, int ind, int w, int[][]dp){
	// 	if(ind==0){
	// 		if(weights.get(0)<=w){
	// 			return values.get(0);
	// 		}else return 0;
	// 	}

	// 	if(dp[ind][w]!=-1){
	// 		return dp[ind][w];
	// 	}

	// 	int nottake=0+knapsack(values, weights, ind-1, w, dp);
	// 	int take=Integer.MIN_VALUE;
	// 	if(weights.get(ind)<=w){
	// 		take=values.get(ind)+knapsack(values, weights, ind-1, w-weights.get(ind), dp);	
	// 	}
	// 	dp[ind][w]=Math.max(take,nottake);
	// 	return dp[ind][w];
	
	// }
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// // Memoization - tc: O(nw) sc: O(nw)+O(n)
		// int[][] dp=new int[n][w+1];
		// for(int[] rows:dp){
		// 	Arrays.fill(rows,-1);
		// }
		// return knapsack(values, weights, n-1, w, dp);

		// // Tabulation - tc: O(nw) sc: O(nw)
		// int[][] dp = new int[n][w + 1];
        // for (int i = weights.get(0); i <= w; i++) {
        //     dp[0][i] = values.get(0);
        // }
        // for (int ind = 1; ind < n; ind++) {
        //     for (int cap = 0; cap <= w; cap++) {
        //         int notTaken = dp[ind - 1][cap];
        //         int taken = Integer.MIN_VALUE;
        //         if (weights.get(ind) <= cap) {
        //             taken = values.get(ind) + dp[ind - 1][cap - weights.get(ind)];
        //         }
        //         dp[ind][cap] = Math.max(notTaken, taken);
        //     }
        // }
        // return dp[n - 1][w];

		// Space optimization - tc: O(nw) sc: O(w)
      	int[] prev = new int[w + 1];
        for (int i = weights.get(0); i <= w; i++) {
            prev[i] = values.get(0);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = w; cap >= 0; cap--) {
                int notTaken = prev[cap];
                int taken = Integer.MIN_VALUE;
                if (weights.get(ind) <= cap) {
                    taken = values.get(ind) + prev[cap - weights.get(ind)];
                }
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        return prev[w];
    }
}
