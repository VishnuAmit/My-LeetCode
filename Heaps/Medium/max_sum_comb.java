// Problem link: https://practice.geeksforgeeks.org/problems/maximum-sum-combination/1
import java.util.*;
class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // // Brute force - tc: O(n2) sc: O(nm)
        // ArrayList<Integer> ans=new ArrayList<>();
        // for(int i=0;i<A.length;i++){
        //     for(int j=0;j<A.length;j++){
        //         int sum=A[i]+B[j];
        //         ans.add(sum);
        //     }
        // }
        // Collections.sort(ans, Collections.reverseOrder());
        
        // List<Integer> result = ans.subList(0, K);
        // return result;
        
        // Optimal - tc: O(max(nlogn,klogn)) sc: O(nlogn).
        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer> ans=new ArrayList<>();
        
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return b[0]-a[0];
        });
        
        for(int i=0;i<N;i++)
        {
          pq.add(new int[]{A[i]+B[N-1],N-1});  
        }
        
        while(!pq.isEmpty() && K-->0){
            int sum=pq.peek()[0];
            int ind=pq.peek()[1];
            pq.poll();
            
            ans.add(sum);
            
            if(ind-1>=0){
                pq.add(new int[]{sum-B[ind]+B[ind-1],ind-1});
            }
            
        }
        
        return ans;
        

    }
}
