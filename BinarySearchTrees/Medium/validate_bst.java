package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;
// Problem link: https://leetcode.com/problems/validate-binary-search-tree/
class Solution {
    public boolean helperfn(TreeNode root, Long minval, Long maxval){
        if(root==null) return true;
        if(root.val>=maxval || root.val<=minval) return false;
        return helperfn(root.left, minval,(long)root.val) && helperfn(root.right,(long)root.val,maxval);
    }
    public boolean isValidBST(TreeNode root) {
        // tc: O(n) sc: O(1)
        return helperfn(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
