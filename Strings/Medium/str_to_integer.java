// Problem link: https://leetcode.com/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String s) {
        if (s == null ) return 0;
          s=s.trim();
         if(s.length()==0) return 0;

        int sign=+1;
            long ans=0;
        if(s.charAt(0)=='-') sign=-1;
  
          int max=Integer.MAX_VALUE, min=Integer.MIN_VALUE;
        int i=(s.charAt(0)=='+' || s.charAt(0)=='-')?1:0;
        while(i<s.length()){
            if(s.charAt(i)==' ' || (!Character.isDigit(s.charAt(i)))) break;
            ans=ans*10+(s.charAt(i)-'0');

            if(sign==-1 && -1*ans<Integer.MIN_VALUE) return min;
            if(sign==1 && ans>Integer.MAX_VALUE) return max;
            i++;
        }
        return (int)(sign*ans);
    }
}