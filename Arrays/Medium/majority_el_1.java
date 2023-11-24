package Medium;
// Problem link: https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        // // Brute force - tc: O(n2) sc: O(1)
        // for(int i=0;i<nums.length;i++){
        //     int cnt=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[j]==nums[i]) cnt++;
        //     }
        //     if(cnt>nums.length/2) return nums[i];
        // }
        // return -1;

        // // Better - O(nlogn+n) sc: O(n)
        // int n=nums.length;
        // HashMap<Integer,Integer> mpp=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     int val=mpp.getOrDefault(nums[i],0);
        //     mpp.put(nums[i],val+1);
        // }
        // for(Map.Entry<Integer,Integer> it: mpp.entrySet()){
        //     if(it.getValue()>n/2) return it.getKey();
        // }
        // return -1;

        // Optimal - tc: O(2n) sc: O(1)
        int n=nums.length;
        int cnt=0,el=0;
        for(int i=0;i<n;i++){
            if(cnt==0){
                cnt=1;
                el=nums[i];
            }else if(el==nums[i]) cnt++;
            else cnt--;
        }

        int cnt1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==el){
                cnt1++;
            }
        }
        if(cnt1>n/2){
            return el;
        }
        return -1;
    }
}
