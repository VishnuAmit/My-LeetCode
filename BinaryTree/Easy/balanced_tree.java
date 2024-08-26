// Problem link: https://leetcode.com/problems/balanced-binary-tree/description/
class Solution {
    public int getheight(TreeNode node){
        // if(node==null) return 0;
        // int lh=getheight(node.left);
        // int rh=getheight(node.right);
        // return Math.max(lh,rh)+1;

        if(node==null) return 0;
        int lh=getheight(node.left);
        if(lh==-1) return -1;
        int rh=getheight(node.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(TreeNode root) {
        // // Brute force - tc: O(n2) sc: O(1)
        // if(root==null) return true;
        // int lefth=getheight(root.left);
        // int righth=getheight(root.right);
        // if(Math.abs(lefth-righth)<=1 && isBalanced(root.left) && isBalanced(root.right)){
        //     return true;
        // }
        // return false;
        

        // Optimal - tc: O(n) sc: O(1)
        return getheight(root)!=-1;
    }
}