import java.util.LinkedList;
import java.util.Queue;
import BinarySearchTrees.TreeNode;
// Problem link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
class Codec {
    // Optimal - tc: O(n) sc: O(n)
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q=new LinkedList<>();
        String [] vals=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        for(int i=1;i<vals.length;i++){
            TreeNode parent=q.poll();
            if(!vals[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(vals[i]));
                parent.left=left;
                q.add(left);
            }
            if(!vals[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(vals[i]));
                parent.right=right;
                q.add(right);
            }
        }
        return root;
    }

}