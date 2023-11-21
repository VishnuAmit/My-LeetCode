package Arrays.Easy;
import java.util.* ;
// Problem link : https://www.codingninjas.com/codestudio/problems/left-rotate-an-array-by-one_5026278?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class left_rotate_array_by_one {

    static int[] rotateArray(int[] arr, int n) {
        // // Brute force - tc: O(n) sc: O(n)
        // int[] temp= new int[n];
        // int k=0;
        // for(int i=1;i<n;i++){
        //     temp[k]=arr[i];
        //     k++;
        // }
        // temp[n-1]=arr[0];
        // return temp;

        // Optimal - tc: O(n) sc: O(1)
        int temp=arr[0];
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i+1];
        }
        arr[n-1]=temp;
        return arr;
    }
}
