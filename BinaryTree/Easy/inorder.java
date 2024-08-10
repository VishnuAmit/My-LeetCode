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

        // Morris traversal - tc: O(2n) sc: O(1)
      TreeNode cur=root;
      ArrayList<Integer> ans=new ArrayList<>();

      while(cur!=null){
        if(cur.left==null){
            ans.add(cur.val);
            cur=cur.right;
        }else{
            TreeNode prev=cur.left;
            while(prev.right!=null && prev.right!=cur){
                prev=prev.right;
            }
            if(prev.right==null){
                prev.right=cur;
                cur=cur.left;
            }else{
                prev.right=null;
                ans.add(cur.val);
                cur=cur.right;
            }
        }
      }
      return  ans;
    }
}