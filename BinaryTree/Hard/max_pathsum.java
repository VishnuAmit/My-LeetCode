// Problem link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
class Solution {
    public int helper(TreeNode node, int[] arr){
        if(node==null) return 0;
        int left=Math.max(0, helper(node.left,arr));
        int right=Math.max(0, helper(node.right,arr));
        arr[0]=Math.max(arr[0], node.val+left+right);
        return Math.max(left,right)+node.val;
    }
    public int maxPathSum(TreeNode root) {
        // Optimal - tc: O(n) sc: O(n)
        int[] maxval=new int[1];
        maxval[0]=Integer.MIN_VALUE;
        helper(root,maxval);
        return maxval[0];

    }
}