package Arrays.Easy;
import java.util.*;
// Problem link : https://www.codingninjas.com/studio/problems/ninja-and-the-sorted-check_6581957?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class is_array_sorted {
    public static int isSorted(int n, int []a) {
        // // Brute force - tc: O(n2) sc: O(1)
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(a[i]>a[j]){
        //             return 0;
        //         }
        //     }
        // }
        // return 1;

        // Optimal - tc: O(n) sc: O(1)
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]) return 0;
        }
        return 1;
    }
}
