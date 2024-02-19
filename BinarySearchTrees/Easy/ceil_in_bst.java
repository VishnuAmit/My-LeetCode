package BinarySearchTrees.Easy;
import BinarySearchTrees.TreeNode;
// Problem link: https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos
class Solution {

    public  static int findCeil(TreeNode node, int x) {
        // Optimal - tc: O(h) sc: O(1)
        int ceil=-1;
        while(node!=null){
            if(node.val==x){
                ceil=node.val;
                return ceil;
            }else if(x>node.val){
                node=node.right;
            }else{
                ceil=node.val;
                node=node.left;
            }
        }
        return ceil;

    }
}
