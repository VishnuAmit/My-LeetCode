// Problem link: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
class Solution {
    // public void preorder(TreeNode node, List<Integer> ans){
    //     if(node==null){
    //         return;
    //     }
    //     ans.add(node.val);
    //     preorder(node.left,ans);
    //     preorder(node.right,ans);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        // // Recursive - tc: O(n) sc: O(n)
        // List<Integer> ans=new ArrayList<>();
        // preorder(root,ans);
        // return ans;

        // // Iterative - tc: O(n) sc: O(n)
        // Stack<TreeNode> st=new Stack<>();
        // ArrayList<Integer> ans=new ArrayList<>();
        // TreeNode node=root;
        // if(node==null) return ans;
        // st.push(node);
        // while(!st.isEmpty()){
        //     node=st.pop();
        //     ans.add(node.val);
        //     if(node.right!=null){
        //         st.push(node.right);
        //     }
        //     if(node.left!=null){
        //         st.push(node.left);
        //     }
    
        // }
        // return ans;

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
                ans.add(cur.val);
                cur=cur.left;
            }else{
                prev.right=null;
                cur=cur.right;
            }
        }
      }
      return  ans;
    }
}