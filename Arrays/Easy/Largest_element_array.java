package Easy; 
import java.util.*;
// Problem link : https://www.codingninjas.com/studio/problems/largest-element-in-the-array-largest-element-in-the-array_5026279?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class Largest_element_array {
    static int largestElement(int[] arr, int n) {
        // // Brute Force - tc: O(nlogn) sc: O(1)
        // Arrays.sort(arr);
        // int sum=arr[n-1];
        // return sum;

        // Optimal - tc: O(n) sc: O(1)
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}