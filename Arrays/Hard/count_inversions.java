package Hard;
// Problem link: https://www.codingninjas.com/codestudio/problems/number-of-inversions_6840276?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.*;
public class Solution {
    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low;    
        int right = mid + 1;  
        int cnt = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); 
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; 
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  
        cnt += mergeSort(arr, mid + 1, high); 
        cnt += merge(arr, low, mid, high); 
        return cnt;
    }
    public static int numberOfInversions(int []a, int n) {
        // // Brute force: tc: O(n2) sc: O(1)
        // int cnt=0;
        // for(int i=0;i<a.length;i++){
        //     for(int j=i+1;j<a.length;j++){
        //         if(a[i]>a[j]) cnt++;
        //     }
        // }
        // return cnt;


        // Optimal - O(nlogn) sc: O(n)
        return mergeSort(a, 0,n-1);


    }
}