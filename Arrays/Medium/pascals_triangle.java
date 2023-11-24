package Medium;

import java.util.ArrayList;
import java.util.List;
// Problem link:  https://leetcode.com/problems/pascals-triangle/
class Solution {

//     // Brute force - tc: O(n2*r) sc: O(1) 
//      public static int nCr(int n, int r) {
//         long res = 1;
//         // calculating nCr:
//         for (int i = 0; i < r; i++) {
//             res = res * (n - i);
//             res = res / (i + 1);
//         }
//         return (int) res;
//     }
    

    public List<List<Integer>> generate(int numRows) {
        // List<List<Integer>> result = new ArrayList<>();
        //  for (int row = 1; row <= numRows; row++) {
        //      List<Integer> temp = new ArrayList<>();
        //      for (int col = 1; col <=row; col++) {
        //          temp.add((int) nCr(row-1, col-1));
        //      }
        //      result.add(temp);
        //  }
        //  return result;

        List<List<Integer>> ans = new ArrayList<>();
         for( int row=1;row<=numRows;row++){
            ans.add( generator(row));
         }
         return ans;
    }

        // Optimal - tc:" O(n2) sc: O(1)
        public List<Integer> generator(int row){
        long ans=1;
        List<Integer> ansrow = new ArrayList<>();
        ansrow.add(1); 
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans=ans/col;
            ansrow.add((int)ans);
        }
        return ansrow;
    }
}

