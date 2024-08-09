// Problem  link: https://leetcode.com/problems/binary-tree-postorder-traversal/description/
class Solution {
    // public void postorder(TreeNode node, List<Integer> ans){
    //     if(node==null){
    //         return;
    //     }
    //     postorder(node.left,ans);
    //     postorder(node.right,ans);
    //     ans.add(node.val);
    // }
    public List<Integer> postorderTraversal(TreeNode root) {
        // // Recursive - tc: O(n) sc: O(n)
        // List<Integer> ans=new ArrayList<>();
        // postorder(root,ans);
        // return ans;

        // Iterative - tc: O(2n) sc: O(n)
        Stack<TreeNode> st=new Stack<>();
          List<Integer> ans=new ArrayList<>();
        TreeNode node=root;
        while(node!=null || !st.isEmpty()){
            if(node!=null){
                st.push(node);
                node=node.left;
            }else{
                TreeNode temp=st.peek().right;
                if(temp==null){
                    temp=st.peek();
                    st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.peek();
                        st.pop();
                        ans.add(temp.val);
                    }
                }else{
                    node=temp;
                }
            }
        }
        return ans;
    }
}