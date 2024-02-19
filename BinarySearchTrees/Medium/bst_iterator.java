package BinarySearchTrees.Medium;
import java.util.Stack;
import BinarySearchTrees.TreeNode;
// Problem link: https://leetcode.com/problems/binary-search-tree-iterator/
class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    // Optimal - tc: O(1) sc: O(h)
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp=st.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            node=node.left;
        }
    }
}