// Problem link: https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // // Brute force - tc: O(n1+n2) sc: O(n1+n2)
        // int n=nums1.length;
        // int m=nums2.length;
        // int i=0,j=0;
        // ArrayList<Integer> ans=new ArrayList<>();
        // while(i<n && j<m){
        // if(nums1[i]<nums2[j]){
        // ans.add(nums1[i]);
        // i++;
        // }else{
        // ans.add(nums2[j]);
        // j++;
        // }
        // }

        // while(i<n){
        // ans.add(nums1[i]);
        // i++;
        // }
        // while(j<m){
        // ans.add(nums2[j]);
        // j++;
        // }

        // if(ans.size()%2==1) return ans.get(ans.size()/2);
        // if(ans.size()%2==0){
        // return (double)(ans.get(ans.size()/2)+ans.get(ans.size()/2-1))/2.0;
        // }
        // return 1.0;

        // // Better - tc: O(n1+n2) sc: O(1)
        // int n = nums1.length;
        // int m = nums2.length;
        // int total = n + m;
        // int ind2 = total / 2;
        // int ind1 = total / 2 - 1;
        // int ind1el = -1, ind2el = -1;
        // int i = 0, j = 0;
        // int cnt=0;
        // while (i < n && j < m) {
        //     if (nums1[i] < nums2[j]) {
        //         if (cnt == ind1)
        //             ind1el = nums1[i];
        //         if (cnt == ind2)
        //             ind2el = nums1[i];
        //         cnt++;
        //         i++;
        //     } else {
        //         if (cnt == ind1)
        //             ind1el = nums2[j];
        //         if (cnt == ind2)
        //             ind2el = nums2[j];
        //         cnt++;
        //         j++;
        //     }
        // }

        // while(i<n){
        //         if (cnt == ind1)
        //             ind1el = nums1[i];
        //         if (cnt == ind2)
        //             ind2el = nums1[i];
        //         cnt++;
        //         i++; 
        // }

        // while(j<m){
        //         if (cnt == ind1)
        //             ind1el = nums2[j];
        //         if (cnt == ind2)
        //             ind2el = nums2[j];
        //         cnt++;
        //         j++;
        // }

        // if(total%2==1) return (double)ind2el;
        // else return (double)(ind1el+ind2el)/2.0;

        // Optimal - tc: O(log(min(n1,n2))) sc: O(1)
        int n1=nums1.length,n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int total=n1+n2;
        int low=0,high=n1;
        int left=(n1+n2+1)/2;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(mid1>0) l1=nums1[mid1-1];
            if(mid2>0) l2=nums2[mid2-1];

            if(l1<=r2 && l2<=r1){
                if(total%2==0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                        return Math.max(l1,l2);
                }
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return 0;

    }
}