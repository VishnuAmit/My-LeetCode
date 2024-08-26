// Problem link: https://leetcode.com/problems/same-tree/description/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Optimal - tc: O(n+m) sc: O(1)
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null) return false;
        return ((p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
    }
}