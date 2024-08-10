// Problem link: https://leetcode.com/problems/diameter-of-binary-tree/
class Solution {
    int dia=0;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        // update dia
        dia=Math.max(dia,lh+rh);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // Brute force - tc: O(n2) sc: O(1) - refer note
        // Optimal - tc: O(n) sc: O(n)
        height(root);
        return dia;
    }
}