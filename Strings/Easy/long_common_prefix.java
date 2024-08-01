// Problem link: https://leetcode.com/problems/longest-common-prefix/description/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // // Brute force - O(nlogn+m) sc: O(1)
        // if(strs==null || strs.length==0) return "";
        // int c=0;
        // Arrays.sort(strs);
        // String first=strs[0];
        // String last=strs[strs.length-1];
        // while(c<first.length()){
        //     if(first.charAt(c)==last.charAt(c)){
        //         c++;
        //     }else{
        //         break;
        //     }
        // }
        // return c==0?"":first.substring(0,c);

        // Optimal - tc: O(n*m) sc: O(1)
        if(strs.length==0) return "";
        String prefix =strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
            if(prefix.isEmpty()) break;
        }
        return prefix;
    }
}