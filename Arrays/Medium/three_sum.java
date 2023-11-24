package Medium;

import java.util.*;
// Problem link: https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    //   // Brute force - tc: O(n3*log(k)) sc: O(2*k) k-> no of uniq triplets 
    //   int n=nums.length;
    //   Set<List<Integer>> st=new HashSet<>();
    //   for(int i=0;i<n;i++){
    //       for(int j=i+1;j<n;j++){
    //           for(int k=j+1;k<n;k++){
    //               if(nums[i]+nums[j]+nums[k]==0){
    //                   List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
    //                   temp.sort(null);
    //                   st.add(temp);
    //               }
    //           }
    //       }
    //   }
    //   List<List<Integer>> ans=new ArrayList<>(st);
    //   return ans;
     
    //  // Better - tc: O(n2*log(k)) sc: O(2*k)
    //  int n=nums.length;
    //  Set<List<Integer>> st=new HashSet<>();
    //  for(int i=0;i<n-1;i++){
    //      Set<Integer> inner_st=new HashSet<>();
    //      for(int j=i+1;j<n;j++){
    //          int third= -(nums[i]+nums[j]);
    //          if(inner_st.contains(third)){
    //              List<Integer> temp = Arrays.asList(nums[i],nums[j],third);
    //              temp.sort(null);
    //              st.add(temp);
    //             }
    //          inner_st.add(nums[j]);
    //      }
    //  }
    // List<List<Integer>> ans=new ArrayList<>(st);
    // return ans;

    // Optimal - tc: O(n2+nlogn) sc: O(1)
    int n=nums.length;
    List<List<Integer>> ans=new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0;i<n;i++){
        if(i!=0 && nums[i]==nums[i-1]) continue;
        int j=i+1;
        int k=n-1;
        while(j<k){
            int sum=nums[i]+nums[j]+nums[k];
            if(sum<0) j++;
            else if(sum>0) k--;
            else{
                List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                ans.add(temp);
                j++;
                k--;
                while (j < k &&  nums[j] ==  nums[j - 1]) j++;
                while (j < k &&  nums[k] ==  nums[k + 1]) k--;
            }

        }
    }
    return ans;
    }
}