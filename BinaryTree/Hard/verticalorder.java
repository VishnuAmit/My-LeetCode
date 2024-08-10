// Problem link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
class tuple{
    TreeNode node;
    int row;
    int col;
    tuple(TreeNode node, int row, int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // tc: O(n*3logn) sc: O(2n)
        Queue<tuple> q=new LinkedList<>();
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> mpp=new TreeMap<>();
        q.offer(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple temp=q.poll();
            TreeNode node=temp.node;
            int x=temp.row;
            int y=temp.col;

            if(!mpp.containsKey(x)){
                mpp.put(x,new TreeMap<>());
            }
            if(!mpp.get(x).containsKey(y)){
                mpp.get(x).put(y, new PriorityQueue<>());
            }
            mpp.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offer(new tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new tuple(node.right,x+1,y+1));
            }
        }

        List<List<Integer>> ans=new ArrayList<>();
        for(Map<Integer,PriorityQueue<Integer>> itr:mpp.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:itr.values()){
                while(!nodes.isEmpty()){
        
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
    return ans;
    }
}