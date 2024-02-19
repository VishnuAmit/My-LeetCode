package Strings.Medium;
import java.util.*;
// Problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // // Brute force - O(n2) sc: O(n)
        // int n=s.length();
        // if(s.length()==0) return 0;
        // int maxlen=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     HashSet<Character> set=new HashSet<>();
        //     for(int j=i;j<n;j++){
        //         if(set.contains(s.charAt(j))){
        //             maxlen=Math.max(maxlen,j-i);
        //             break;
        //         }
        //         set.add(s.charAt(j));
        //     }

        // }
        // return maxlen;

        // // Better - tc: O(2n) sc: O(n)
        // int n=s.length();
        // if(s.length()==0) return 0;
        // HashSet<Character> set=new HashSet<>();
        // int maxlen=Integer.MIN_VALUE;
        // int left=0;
        // for(int r=0;r<n;r++){
        //     if(set.contains(s.charAt(r))){
        //         while(left<r && set.contains(s.charAt(r))){
        //             set.remove(s.charAt(left));
        //             left++;
        //         }
        //     }
        //     set.add(s.charAt(r));
        //     maxlen=Math.max(maxlen,r-left+1);
        //     }
        //     return maxlen;

        // Optimal - tc: O(n) sc: O(n)
        int n=s.length();
        if(s.length()==0) return 0;
        Map<Character,Integer> mpp=new HashMap<>();
        int len=0,left=0,right=0;
        while(right<n){
            if(mpp.containsKey(s.charAt(right))){
                left=Math.max(left, mpp.get(s.charAt(right))+1);
            }
            mpp.put(s.charAt(right),right);
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;

    }
}