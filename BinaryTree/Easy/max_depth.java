// Problem link: https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
class Solution {
    public int maxDepth(TreeNode root) {
        // tc: O(n) sc: O(n)
        if(root==null) return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return 1+Math.max(lh,rh);
    }
}