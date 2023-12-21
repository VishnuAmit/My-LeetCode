package Hard;
// Problem link: https://leetcode.com/problems/find-median-from-data-stream/
import java.util.*;
class MedianFinder {
    // List<Integer> ans;
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());
    public MedianFinder() {
        // ans=new ArrayList<>()
    }
    
    public void addNum(int num) {
        // ans.add(num);
        max.offer(num);
        min.offer(max.poll());
        if(max.size()<min.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        // // Brute force - tc: O(nlogn) sc: O(n)
        // double median=Double.MAX_VALUE;
        // Collections.sort(ans);
        // int size=ans.size();
        // if(size%2==0){
        //     median=(ans.get((size-1)/2)+ans.get(size/2))/2.0D;
        // }else{
        //     median=ans.get(size/2)/1.0D;
        // }
        // return median;

        // Optimal - tc: O(logn) sc: O(n)
        if(max.size()==min.size()) return (max.peek()+min.peek())/2.0D;
        else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
