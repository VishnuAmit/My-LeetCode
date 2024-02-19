package BinarySearchTrees.Easy;
import BinarySearchTrees.TreeNode;
// Problem link: https://leetcode.com/problems/search-in-a-binary-search-tree/
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // tc: O(logn) sc: O(1)
        while(root!=null && root.val!=val){
            if(val<root.val){
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return root;
    }
}
