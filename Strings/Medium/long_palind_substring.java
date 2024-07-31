// Problem link: https://leetcode.com/problems/longest-palindromic-substring/description/
class Solution {
    public String longestPalindrome(String s) {

        // Brute force - tc: O(n3) sc: O(1) -> n for checking palindromes & n2 for every substring
        // Optimal - tc: O(n2) sc: O(1)
        String str="";
        int curlen=0;
        // odd
        for(int i=0;i<s.length();i++){
            int left=i;
            int right=i;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(right-left+1>curlen){
                str=s.substring(left,right+1);
                curlen=right-left+1;
                }
                left-=1;
                right+=1;
            }
        }

        // even
          for(int i=0;i<s.length();i++){
            int left=i;
            int right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(right-left+1>curlen){
                str=s.substring(left,right+1);
                curlen=right-left+1;
                }
                left-=1;
                right+=1;
            }
        }
        return str;


    }
}