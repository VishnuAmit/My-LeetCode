package Tries.Medium;
// Problem link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
class Node{
    Node links[ ]= new Node[2];

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
    public Node root;
    public Trie(){
        root=new Node();
    }
    public  void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node=node.get(bit);
        }
    }

    public  int getmax(int num){
        Node node=root;
        int maxnum=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.containsKey(1-bit)){
                maxnum= maxnum | (1<<i);
                node=node.get(1-bit);
            }else{
                node=node.get(bit);
            }
        }
        return maxnum;
    }

}

class Solution {
    public int findMaximumXOR(int[] nums) {
        // tc - O(n*32) sc: O(n*32)
        Trie obj=new Trie();
        for(int i=0;i<nums.length;i++){
            obj.insert(nums[i]);
        }
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,obj.getmax(nums[i]));
        }
        return maxi;
    }
}

