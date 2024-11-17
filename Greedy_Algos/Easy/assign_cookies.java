package Greedy_Algos.Easy;
import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // tc: O(nlogn+mlogm+m) sc: O(1)
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0;
        int n=g.length;
        int m=s.length;
        int i=n-1,j=m-1;

        while(i>=0 && j>=0){
            if(s[j]>=g[i]){
                cnt++;
                j--;
                i--;
            }else{
                i--;
            }
        }
        return cnt;
    }
}