// Problem link: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
class Solution {
    // public void helperinorder(TreeNode node, ArrayList<Integer> ans){
    //     if(node==null) return;
    //     helperinorder(node.left,ans);
    //     ans.add(node.val);
    //     helperinorder(node.right,ans);
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        // // Recursive - tc: O(n) sc: O(n)
        // ArrayList<Integer> ans=new ArrayList<>();
        // helperinorder(root,ans);
        // return  ans;
        

        // Iterative - tc: O(n) sc: O(n)
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }else{
                if(st.isEmpty()) break;
                node=st.pop();
                ans.add(node.val);
                node=node.right;
            }
        }
        return ans;
    }
}