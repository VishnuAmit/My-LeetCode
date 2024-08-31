// Problem link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
class Solution {
    public TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend,Map<Integer,Integer> mpp){
        if(prestart>preend || instart>inend) return null;
        TreeNode root=new TreeNode(preorder[prestart]);

        int inroot=mpp.get(root.val);
        int numsleft=inroot-instart;

        root.left=helper(preorder,prestart+1,prestart+numsleft,inorder,instart,inroot-1,mpp);
        root.right=helper(preorder,prestart+numsleft+1,preend,inorder,inroot+1,inend,mpp);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Optimal - tc: O(n) sc: O(n)
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        TreeNode root=helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mpp);
        return root;


    }
}