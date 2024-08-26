// Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Brute force - use another ds n find the last match

        // Optimal - tc: O(n) sc: O(n)
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }

    }
}