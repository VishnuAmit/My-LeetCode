// Problem link: https://leetcode.com/problems/binary-tree-right-side-view/
class Solution {
    public void helper(TreeNode node, List<Integer> ans, int level){
        if(node==null){
            return;
        }
        if(level==ans.size()){
            ans.add(node.val);
        }

        helper(node.right,ans,level+1);
        helper(node.left,ans,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        // // recursive - tc: O(n) sc: O(h)
        // ArrayList<Integer> ans=new ArrayList<>();
        // helper(root,ans,0);
        // return ans;


        // Iterative - tc: O(n) sc: O(w)
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        if(root==null) return ans;
        while(!q.isEmpty()){
            int cursize=q.size();

            for(int i=0;i<cursize;i++){
                TreeNode node=q.poll();
                
                if(i==cursize-1){
                    ans.add(node.val);
                }

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }

    return ans;


    }
}
