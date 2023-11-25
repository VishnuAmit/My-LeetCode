package Medium;

import java.util.*;
// Problem link: https://leetcode.com/problems/4sum/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // // Brute force - tc: O(n4) sc: O(2k) k-> no of quadruplets
        // int n=nums.length;
        // HashSet<List<Integer>> st=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             for(int p=k+1;p<n;p++){
        //                 if(nums[i]+nums[j]+nums[k]+nums[p]==target){
        //                     List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[p]);
        //                     temp.sort(null);
        //                     st.add(temp);
        //                 }
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> ans=new ArrayList<>(st);
        // return ans;

        // // Better - tc: O(n3logm) sc: O(2k+n)
        // int n=nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         Set<Long> hashset=new HashSet<>();
        //         for(int k=j+1;k<n;k++){
        //             long sum=nums[i]+nums[j];
        //             sum+=nums[k];
        //             long fourth=target-sum;
        //             if(hashset.contains(fourth)){
        //                 List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
        //                 temp.sort(null);
        //                 set.add(temp);
        //             }
        //             hashset.add((long)nums[k]);
        //         }
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList<>(set);
        // return ans;

        // Optimal - tc: O(n3) sc: O(1)
        List<List<Integer>> ans = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int p=n-1;
                while(k<p){
                    long sum=nums[i];
                    sum+=nums[j]+nums[k];
                    sum+=nums[p];
                    if(sum==target){
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[p]);
                        temp.sort(null);
                        ans.add(temp);
                        k++;
                        p--;
                        while (k < p &&  nums[k] ==  nums[k - 1]) k++;
                        while (k < p &&  nums[p] ==  nums[p + 1]) p--;
                    }else if(sum<target) k++;
                    else p--;
                }
            }
        }
        return ans;

    }
}