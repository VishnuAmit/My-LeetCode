// Problem link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

class Solution {
    public int strStr(String haystack, String needle) {
        // Brute force - tc: O((n-m)*m) sc: O(m)
        for(int i=0;i<=haystack.length() - needle.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                // System.out.println(i);
                return i;
            }
        }
        return -1;

        // Optimal - study kkmp algo :(
    }
}