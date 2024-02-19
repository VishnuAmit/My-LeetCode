package BinarySearchTrees.Medium;
import java.util.*;
import BinarySearchTrees.TreeNode;
// Problem link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    boolean reverse=true; // before

    public BSTIterator(TreeNode root, boolean isreverse) {
        reverse=isreverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp=st.pop();
        if(reverse==true){
            pushAll(temp.left);
        }else{
            pushAll(temp.right);
        }
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse==true){
                node=node.right;
            }else{
                node=node.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // Optimal - tc: O(n) sc: O(2h)
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
}
