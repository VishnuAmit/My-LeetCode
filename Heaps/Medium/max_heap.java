import java.util.ArrayList;
// Problem link: https://www.codingninjas.com/studio/problems/build-heap_975375?leftPanelTabValue=PROBLEM

class Solution {

    // tc: O(nlogn) sc: O(1)
    public static void heapify(ArrayList<Integer> heap, int k, int size){
        int largest=k;
        int left=2*k+1;
        int right=2*k+2;

        if(left<size &&  heap.get(left)>heap.get(largest)){
            largest=left;
        }

        if(right<size &&  heap.get(right)>heap.get(largest)){
            largest=right;
        }
        if(largest!=k){
            int temp=heap.get(k);
            heap.set(k, heap.get(largest));
            heap.set(largest,temp);

            heapify(heap,largest,size);
        }

    }
    public static ArrayList<Integer> buildHeap(ArrayList<Integer> arr, int n) {
        int startindex=(n/2)-1;
        for(int i=startindex;i>=0;i--){
            heapify(arr, i, n);
        }
        return arr;
    }
}