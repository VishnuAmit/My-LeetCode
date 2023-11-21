package Arrays.Easy;
import java.util.*;
class Solution {
    public static List<Integer> sortedArray(int[] a, int[] b) {
        // // Brute force - tc: O(2nlogn+2n) sc: O(n1+n2)+O(n1+n2) -> return the ans
        // Set<Integer> set=new HashSet<>();
        // ArrayList<Integer> ans=new ArrayList<>();
        // for(int num:a){
        //     set.add(num);
        // }
        // for(int num:b){
        //     set.add(num);
        // }
        // for(int it:set){
        //     ans.add(it);
        // }
        // return ans;

        // Optimal - tc: O(n1+n2) sc:O(n1+n2)->return the ans
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                    ans.add(a[i]);
                }
                i++;
            } else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                    ans.add(b[j]);
                }
                j++;
            }
        }

        while (i < a.length) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                ans.add(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                ans.add(b[j]);
            }
            j++;
        }

        return ans;
    }
}
