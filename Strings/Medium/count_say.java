// Problem link: https://leetcode.com/problems/count-and-say/
class Solution {
    public String countAndSay(int n) {
        // Brute force - tc: O(2^n) sc: O(2^n)
       if(n==1) return "1"; 
       if(n==2) return "11";
       String s="11";
       for(int i=3;i<=n;i++){
            int cnt=1;
            String t="";
            s=s+'&';
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)!=s.charAt(j-1)){
                    t=t+Integer.toString(cnt);
                    t=t+s.charAt(j-1);
                    cnt=1;
                }else{
                    cnt++;
                }
            }
            s=t;
       } 
       return s;
    }
}