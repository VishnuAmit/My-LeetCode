package Tries.Easy;
import java.util.*;

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Brute force - tc: O(2^n*n) sc - O(1)
        ArrayList<String> ans = new ArrayList<>();
        int n=s.length();
        for(int num=0;num<(1<<n);num++){
            String sub="";
            for(int i=0;i<n;i++){
                if((num & (1<<i))!=0){
                    sub+=s.charAt(i);
                }
            }
            if(sub.length()>0){
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
        
        
    }
}