// Problem link: https://leetcode.com/problems/invert-binary-tree/description/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // // Iterative - tc:O(n) sc: O(n)
        // Queue<TreeNode> q=new LinkedList<>();
        // if(root!=null){
        //     q.offer(root);
        // }
        // while(!q.isEmpty()){
        //     TreeNode node=q.poll();
        //     if(node.left!=null){
        //         q.offer(node.left);
        //     }
        //     if(node.right!=null){
        //         q.offer(node.right);
        //     }
        //     TreeNode cur=node.left;
        //     node.left=node.right;
        //     node.right=cur;
        // }
        // return root;

        // Recursive - tc: O(n) sc: O(1)
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
            TreeNode cur=root.left;
            root.left=root.right;
            root.right=cur;
            return  root;
    }
}