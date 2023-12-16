// Problem link: https://www.codingninjas.com/studio/problems/immediate-smaller-element-_1062597?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
class Solution {
    public static void immediateSmaller(int []a) {
    // //     // Brute force - O(n2) sc: O(1)
    //    for(int i=0;i<a.length-1;i++){
    //        for(int j=i+1;j<a.length;j++){
    //            if(a[i]>a[j]){
    //                a[i]=a[j];
    //                break;
    //            }else{
    //                a[i]=-1;
    //            }
    //        }
    //    }
    //    a[a.length-1]=-1;


        // Better - tc: O(n) sc: O(n)
        // int n = a.length;
        // Stack<Integer> st = new Stack<Integer>();
        // st.push(a[0]);
        // for(int i=1;i<n;i++){
        //     if(st.peek()>a[i]){
        //         a[i-1]=a[i];
        //     }else{
        //         a[i-1]=-1;
        //     }
        //     st.push(a[i]);
        // }
        // a[n-1]=-1;

        // Optimal - tc: O(n) sc: O(1)
        for(int i=0;i<a.length-1;i++){
               if(a[i]>a[i+1]){
                   a[i]=a[i+1];
               }else{
                   a[i]=-1;
               }
           }
    
        a[a.length-1]=-1;
    }
}

