package Easy;
// Problem link : https://www.codingninjas.com/codestudio/problems/linear-search_6922070?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.*;
public class linear_search {
    public static int linearSearch(int n, int num, int []arr){
        // Brute force - tc: O(n) sc: O(1)
        for(int i=0;i<n;i++){
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }
}
