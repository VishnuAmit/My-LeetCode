package Greedy_Algos.Medium;
import java.util.Arrays;
// Problem link: https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        // Optimal - tc : O(nlogn+nm) sc: O(m)
        Arrays.sort(arr, (a,b)-> (b.profit - a.profit));
        int maxi=0;
        for(int i=0;i<n;i++){
            if(arr[i].deadline>maxi) maxi=arr[i].deadline;
        }
        int[] res=new int[maxi+1];
         Arrays.fill(res,-1);
        int cntjobs=0,maxprofit=0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(res[j]==-1){
                    res[j]=i;
                    cntjobs++;
                    maxprofit+=arr[i].profit;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = cntjobs;
        ans[1] = maxprofit;
        return ans;
 
    }
}

