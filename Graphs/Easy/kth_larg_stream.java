package Graphs.Easy;
import java.util.*;
// Problem link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
class KthLargest {
    // tc: O(nlogk) sc: O(k)
    private int k;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.minHeap=new PriorityQueue<>();
        for(int i:nums){
            add(i);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()> k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

