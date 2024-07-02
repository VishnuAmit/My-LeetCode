// Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // tc: O(h) sc: O(1)
        if(root==null) return null;
        int cur=root.val;
        if(cur<p.val && cur<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(cur>p.val && cur>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}