// Problem link: https://leetcode.com/problems/root-equals-sum-of-children/
class Solution {
    public boolean checkTree(TreeNode root) {
        // Optimal - tc: O(1) sc: O(1)
        return (root.left.val+root.right.val==root.val);
    }
}