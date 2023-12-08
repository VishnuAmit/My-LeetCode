package Tries.Hard;
import java.util.Arrays;
// Problem link: https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
class Node{
    Node links[]=new Node[2];
    boolean containsKey(int bit){
        return(links[bit]!=null);
    }
    void put(int bit, Node node){
        links[bit]=node;
    }
    Node get(int bit){
        return links[bit];
    }
}
class Trie{
    private static Node root;
    Trie(){
        root=new Node();
    }
    public static void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node=node.get(bit);
        }
    }

    public int getmax(int num){
        int maxnum=0;
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit)){
                maxnum=maxnum | (1<<i);
                node=node.get(1-bit);
            }else{
              node=node.get(bit);
            }
        }
        return maxnum;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
      // // Brute force - tc: O(q*n) sc: O(1)
      // int n=nums.length;
      // int m=queries.length;
      // int [] ans = new int[m];
      // for(int i=0;i<m;i++){
      //   Arrays.fill(ans,-1);
      // }
      // for(int i=0;i<m;i++){
      //   for(int j=0;j<n;j++){
      //     if(nums[j]<=queries[i][1]){
      //         int temp=Math.max(ans[i],nums[j]^queries[i][0]);
      //         ans[i]=temp;
      //     }
      //   }
      // }
      // return ans;
      
      // Optimal - tc: O(m)+O(mlogm)+O(m*32 + n*32) sc: O(32*n)
        Arrays.sort(nums);
        int[] ans=new int[queries.length];
        int[][] ofq=new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            ofq[i][0]=queries[i][0];
            ofq[i][1]=queries[i][1];
            ofq[i][2]=i;
        }
        Arrays.sort(ofq, (a,b)->(a[1]-b[1]));
        int ind=0;
        Trie obj=new Trie();
        for(int query[]:ofq){
            while(ind<nums.length && nums[ind]<=query[1]){
                obj.insert(nums[ind]);
                ind++;
            }
            int tmp=-1;
            if(ind!=0){
                tmp=obj.getmax(query[0]);
            }
            ans[query[2]]=tmp;
        }
        return ans;
    }
}