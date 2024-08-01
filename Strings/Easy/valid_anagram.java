// Problem link: https://leetcode.com/problems/valid-anagram/description/
class Solution {
    public boolean isAnagram(String s, String t) {
        // // Brute force - tc: O(nlogn+mlogm) sc: O(n)
        // char[] sarr=s.toCharArray();
        // char [] tarr=t.toCharArray();
        // if(s.length()!=t.length()) return false;
        // Arrays.sort(sarr);
        // Arrays.sort(tarr);
        // for(int i=0;i<sarr.length;i++){
        //     if(sarr[i]!=tarr[i]) return false;
        // }
        // return true;

        // // Better - tc: O(n+m) sc: O(min(m,n))
        // Map<Character,Integer> mpp=new HashMap<>();
        // for(char c:s.toCharArray()){
        //     mpp.put(c,mpp.getOrDefault(c,0)+1);
        // }
        // for(char c:t.toCharArray()){
        //     mpp.put(c,mpp.getOrDefault(c,0)-1);
        // }

        // for(int vals:mpp.values()){
        //     if(vals!=0){
        //         return false;
        //     }
        // }
        // return true;

        // Optimal - tc: O(n+m) sc: O(1)
        char[] arr=new char[26];

        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c:t.toCharArray()){
            arr[c-'a']--;
        }

        for(int cnt:arr){
            if(cnt!=0) return false;
        }
        return true;
    }
}