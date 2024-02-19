package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;
// Problem link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        // Optimal - tc: O(3n) sc: O(1)
        return helperfunction(preorder,Integer.MAX_VALUE,new int[] {0});

        
    }
    public TreeNode helperfunction(int[] a, int bound, int[] i){
        if(i[0]==a.length || a[i[0]]>bound) return null;
        TreeNode root=new TreeNode(a[i[0]++]);
        root.left=helperfunction(a,root.val,i);
        root.right=helperfunction(a,bound,i);
        return root;
    }
}
