package Easy;

import java.util.*;
// Problem link : https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class second_largest_number {
    public static int secondlargest(int n, int[] a){
        // // Better - tc: O(2n) sc: O(1)
        // int largest=Integer.MIN_VALUE;
        // int slargest=Integer.MIN_VALUE;

        // for(int i=0;i<n;i++){
        //     largest=Math.max(a[i],largest);
        // }

        // for(int i=0;i<n;i++){
        //     if(a[i]!=largest && a[i]>slargest){
        //         slargest=a[i];
        //     }
        // }
        // return slargest;

        // Optimal - tc : O(n) sc: O(1);
        int largest=a[0];
        int slargest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]>largest){
                slargest=largest;
                largest=a[i];
            }else if(a[i]!=largest && a[i]>slargest){
                slargest=a[i];
            }
        }
        return slargest;
    }
    public static int secondsmallest(int n, int[] a){
        // // Better - tc: O(2n) sc: O(1)
        // int smallest=Integer.MAX_VALUE;
        // int s_smallest=Integer.MAX_VALUE;

        // for(int i=0;i<n;i++){
        //     smallest=Math.min(a[i],smallest);
        // }

        // for(int i=0;i<n;i++){
        //     if(a[i]!=smallest && a[i]<s_smallest){
        //         s_smallest=a[i];
        //     }
        // }
        // return s_smallest;

        // Optimal - tc : O(n) sc: O(1);
        int smallest=a[0];
        int s_smallest=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]<smallest){
                s_smallest=smallest;
                smallest=a[i];
            }else if(a[i]!=smallest && a[i]<s_smallest){
                s_smallest=a[i];
            }
        }
        return s_smallest;
    }
    public static int[] getSecondOrderElements(int n, int []a) {
        // // Brute force - tc: O(nlogn) sc: O(1);
        // Arrays.sort(a);
        int[] result = new int[2];
        result[0] = secondlargest(n,a);
        result[1] = secondsmallest(n, a);
        return result;


    }
}