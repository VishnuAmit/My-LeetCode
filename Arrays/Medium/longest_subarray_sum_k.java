package Medium;
// Problem link: https://www.codingninjas.com/codestudio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // // Brute force - tc: O(n2) sc: O(1)
        // int longest=0;
        // for(int i=0;i<a.length;i++){
        //     int sum=0;
        //     for(int j=i;j<a.length;j++){
        //         sum+=a[j];
        //         if(sum==k){
        //             longest=Math.max(longest,j-i+1);
        //         }
        //     }
        // }
        // return longest;

        // // Better - tc: O(nlogn) sc: O(n) 
        // this one solves negatives too
        // int n = a.length;
        // Map<Long, Integer> mpp = new HashMap<>();
        // long sum = 0;
        // int maxLen = 0;
        // for (int i = 0; i < n; i++) {
        //     sum += a[i];
        //     if (sum == k) {
        //         maxLen = Math.max(maxLen, i + 1);
        //     }
        //     long rem = sum - k;
        //     if (mpp.containsKey(rem)) {
        //         int len = i - mpp.get(rem);
        //         maxLen = Math.max(maxLen, len);
        //     }
        //     if (!mpp.containsKey(sum)) {
        //         mpp.put(sum, i);
        //     }
        // }
        // return maxLen;

        // Optimal - O(2n) sc: O(1) 
        // only for positives n zeros
        int left=0,right=0,maxlen=0;
        int sum=a[0];
        int n=a.length;
        while(right<n){
            while(left<=right && sum>k){
                sum-=a[left];
                left++;
            }
            if(sum==k){
                maxlen=Math.max(maxlen,right-left+1);
            }
            right++;
            if(right<n) sum+=a[right];
        }
        return maxlen;
   
    }
}
