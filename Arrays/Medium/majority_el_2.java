package Medium;
import java.util.ArrayList;
import java.util.List;
// Problem link: https://leetcode.com/problems/majority-element-ii/  
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // // Brute force - tc: O(n2) sc: O(1)
        // int n=nums.length;
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     if(ans.size()==0 || ans.get(0)!=nums[i]){
        //         int cnt=0;
        //         for(int j=0;j<n;j++){
        //             if(nums[j]==nums[i]){
        //                 cnt++;
        //             }
        //         }
        //         if(cnt>n/3){
        //             ans.add(nums[i]);
        //         }
        //     }
        //     if(ans.size()==2) break;
        // }
        // return ans;

        // // Better - tc: O(nlogn) sc: O(n)
        // ArrayList<Integer> ans = new ArrayList<>();
        // int n=nums.length;
        // HashMap<Integer,Integer> mpp=new HashMap<>();
        // int min = (int)(n/3)+1;
        // for(int i=0;i<n;i++){
        //     int val=mpp.getOrDefault(nums[i],0);
        //     mpp.put(nums[i],val+1);
        //     if(mpp.get(nums[i])==min) ans.add(nums[i]);
        //     if(ans.size()==2) break;
        // }
        // return ans;

        // Optimal - tc:O(2n) sc: O(1)
        int n=nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt1=0,cnt2=0,el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1==0 && el2!=nums[i]){
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && el1!=nums[i]){
                cnt2=1;
                el2=nums[i];
            }else if(nums[i]==el1) cnt1++;
            else if(nums[i]==el2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        int cnt11=0,cnt22=0;
        int min=(int)(n/3)+1;
        for(int i=0;i<n;i++){
            if(nums[i]==el1) cnt11++;
            if(nums[i]==el2) cnt22++;
        }
        if(cnt11>=min) ans.add(el1);
        if(cnt22>=min) ans.add(el2);
        return ans;
    }
}
