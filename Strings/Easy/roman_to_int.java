class Solution {
    // Problem link: https://leetcode.com/problems/roman-to-integer/description/
    public int romanToInt(String s) {
        // tc: O(n) sc: O(1)
        Map<Character,Integer> mpp=new HashMap<>();
        mpp.put('I',1);
        mpp.put('V',5);
        mpp.put('X',10);
        mpp.put('L',50);
        mpp.put('C',100);
        mpp.put('D',500);
        mpp.put('M',1000);
        int res=0;

        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && mpp.get(s.charAt(i))<mpp.get(s.charAt(i+1))){
                res-=mpp.get(s.charAt(i));
            }else{
                res+=mpp.get(s.charAt(i));
            }
        }
        return res;
    }
}