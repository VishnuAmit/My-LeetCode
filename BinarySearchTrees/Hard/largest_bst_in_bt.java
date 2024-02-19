package BinarySearchTrees.Hard;
import BinarySearchTrees.TreeNode;
// Problem link: https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
class Nodeval{
    public int maxnode,minnode,maxsize;

    public Nodeval(int maxnode,int minnode,int maxsize){
        this.maxnode=maxnode;
        this.minnode=minnode;
        this.maxsize=maxsize;
    }
}
class Solution {
    int max=0;
    public Nodeval fnhelp(TreeNode root){
        if(root==null) return new Nodeval(Integer.MIN_VALUE,Integer.MAX_VALUE,0);

        Nodeval left=fnhelp(root.left);
        Nodeval right=fnhelp(root.right);

        if(left.maxnode<root.val && root.val<right.minnode){
            max=Math.max(max,root.val+left.maxsize+right.maxsize);
            return new Nodeval(Math.max(root.val,right.maxnode),Math.min(root.val,left.minnode),left.maxsize+right.maxsize+root.val);
        }
        return new Nodeval(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxsize,right.maxsize));
    }

    public int maxSumBST(TreeNode root) {
        // tc: O(n) sc: O(1)
        fnhelp(root);
        return max;
        
    }
}
