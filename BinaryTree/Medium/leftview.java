// PRoblem link: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
class Solution {
    // Function to return list containing elements of left view of binary tree.
    public void helper(Node root, int level, List<Integer> ans){
        if(root==null){
            return;
        }
        
        if(level==ans.size()){
            ans.add(root.data);
        }
        helper(root.left,level+1,ans);
        helper(root.right,level+1,ans);
    }
    ArrayList<Integer> leftView(Node root) {
        // code here
        //     // tc - O(n) sc: O(h)
        //   ArrayList<Integer> ans=new ArrayList<>();
        //   helper(root,0,ans);
        //   return ans;
        
         // Iterative - tc: O(n) sc: O(w)
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        if(root==null) return ans;
        while(!q.isEmpty()){
            int cursize=q.size();

            for(int i=0;i<cursize;i++){
                Node node=q.poll();
                
                if(i==0){
                    ans.add(node.data);
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
