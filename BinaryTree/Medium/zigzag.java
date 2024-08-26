// Problem link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Optimal - tc: O(n) sc: O(n)
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> temp=new ArrayList<>(Collections.nCopies(sz,0));
            for(int i=0;i<sz;i++){
                TreeNode el = q.poll(); 
                int index=(flag)?i:(sz-1-i);
                temp.set(index,el.val);
                if(el.left!=null){
                    q.offer(el.left);
                }
                if(el.right!=null){
                    q.offer(el.right);
                }
            }
            flag=!flag;
            result.add(temp);

        }
        return result;
    }
}