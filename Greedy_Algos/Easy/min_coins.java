package Greedy_Algos.Easy;
import java.util.*;
// Problem link: https://www.codingninjas.com/studio/problems/find-minimum-number-of-coins_975277?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Optimal - tc: O(v) sc: O(1)
         ArrayList < Integer > ans = new ArrayList <>();
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int len = coins.length;
	     for(int i=len-1;i>=0;i--){
	        while(n>=coins[i]){
	            n-=coins[i];
	            ans.add(coins[i]);
	        }
	    }
        return ans;
    }
}

