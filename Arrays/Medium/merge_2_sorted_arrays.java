package Medium;

// Problem link: https://www.codingninjas.com/codestudio/problems/merge-two-sorted-arrays-without-extra-space_6898839?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.Arrays;
class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
    // // Brute force - tc: O(n+m) sc: O(n+m)
    // int m = a.length;
    // int n = b.length;
    // long[] nums3 = new long[m + n];
    // int left = 0, right = 0, index = 0;

    // while (left < m && right < n) {
    //     if (a[left] <= b[right]) {
    //         nums3[index] = a[left];
    //         left++;
    //     } else {
    //         nums3[index] = b[right];
    //         right++;
    //     }
    //     index++;
    // }

    // while (left < m) {
    //     nums3[index] = a[left];
    //     left++;
    //     index++;
    // }

    // while (right < n) {
    //     nums3[index] = b[right];
    //     right++;
    //     index++;
    // }

    // for (int i = 0; i < m + n; i++) {
    //     if (i < m) a[i] = nums3[i];
    //     else b[i - m] = nums3[i];
    // }
    
    // // Better - tc: O((n+m)log(n+m)) sc: O(1)
        // for(int i=0;i<n;i++){
        //     nums1[m+i]=nums2[i];
        // }
        // Arrays.sort(nums1);

    // Optimal - tc: O(min(n,m)+nlogn+mlogm) sc: O(1)
        int left=a.length-1;
        int right=0;
        while(left>=0 && right<b.length){
            if(a[left]>b[right]){
                long temp=a[left];
                a[left]=b[right];
                b[right]=temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}