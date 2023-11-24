package Easy;
// Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        // // Brute force - tc:O(n2) sc: O(1)
        // int maxpro=0;
        // for(int i=0;i<prices.length;i++){
        //     for(int j=i+1;j<prices.length;j++){
        //         if(prices[j]>prices[i]){
        //             maxpro=Math.max(prices[j]-prices[i],maxpro);
        //         }
        //     }
        // }
        // return maxpro;

        // Optimal - O(n) sc: O(1)
        int maxpro=0;
        int min_price=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            min_price=Math.min(min_price,prices[i]);
            maxpro=Math.max(maxpro,prices[i]-min_price);
        }
        return maxpro;
    }
}
