// Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // tc: O(n) sc: O(n)
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                temp.add(q.poll().val);
            }
            ans.add(temp);
        }
        return ans;
    
    }
}