// Problem link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
class Solution {
    public TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend, Map<Integer,Integer> mpp){
        if(instart>inend || poststart>postend) return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int inroot=mpp.get(root.val);
        int numsleft=inroot-instart;

        root.left=helper(inorder,instart,inroot-1,postorder,poststart,poststart+numsleft-1,mpp);
        root.right=helper(inorder,inroot+1,inend,postorder,poststart+numsleft,postend-1,mpp);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Optimal - tc: O(n) sc: O(n)
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        TreeNode root=helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,mpp);
        return root;


    }
}