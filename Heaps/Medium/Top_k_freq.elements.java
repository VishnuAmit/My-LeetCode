//Problem link: https://leetcode.com/problems/top-k-frequent-elements/
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // // Brute force - tc: O(n + k*log(u)) sc: O(u)
        // Map<Integer, Integer> mpp=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        // }
        // Queue<Pair<Integer,Integer>> q=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        // mpp.forEach((key,val)->{
        //     q.add(new Pair(key,val));
        // });
        // int[] ans=new int[k];
        // for(int i=0;i<k;i++){
        //     ans[i]=q.poll().getKey();
        // }
        // return ans;

        // Optimal - tc: O(n) sc: O(n)
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        ArrayList<List<Integer>> temp=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length+1;i++){
            temp.add(new ArrayList<Integer>());
        }
        for(int i: mpp.keySet()){
            temp.get(mpp.get(i)).add(i);
        }

        int[] ans=new int[k];
        int idx=0;
        for(int i=temp.size()-1;i>=0;i--){
            int j=0;
            while(j<temp.get(i).size() && idx<k){
                ans[idx]=temp.get(i).get(j);
                idx++;
                j++;
            }
        }
        return ans;
    }
}