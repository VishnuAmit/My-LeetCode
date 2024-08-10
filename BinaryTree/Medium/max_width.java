// Problem link: https://leetcode.com/problems/maximum-width-of-binary-tree/
class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num){
        this.node=node;
        this.num=num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // tc: O(n) sc: O(n)
        Queue<Pair> q=new LinkedList<>();
        if(root==null) return 0;
        int ans=0;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int mmin=q.peek().num;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int cur_id=q.peek().num-mmin;
                TreeNode node=q.peek().node;
                q.poll();
                if(i==0) first=cur_id;
                if(i==size-1) last=cur_id;
                if(node.left!=null){
                    q.offer(new Pair(node.left,2*cur_id+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right,2*cur_id+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}