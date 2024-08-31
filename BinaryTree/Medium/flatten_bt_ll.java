// Problem link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        // // Brute force - tc: O(n) sc: O(h)
        // if(root==null) return;
        // flatten(root.right);
        // flatten(root.left);
        // root.right=prev;
        // root.left=null;
        // prev=root;
        
        // Optimal - tc: O(n) sc: O(1)
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode prev=cur.left;
                while(prev.right!=null){
                    prev=prev.right;
                }
                prev.right=cur.right;
                cur.right=cur.left;
            }
            cur.left=null;
            cur=cur.right;
        }
    }
}