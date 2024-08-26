// Problem link: https://leetcode.com/problems/symmetric-tree/description/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || helper(root.left,root.right);
    }
    static boolean helper(TreeNode left,TreeNode right){
        // Optimal - tc: O(n) sc: O(1)
        if(left==null || right==null){
            return left==right;
        }
        if(left.val!=right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}