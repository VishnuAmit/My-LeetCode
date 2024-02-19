package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;
// Problem link: https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos
class Solution {

    public static int floorInBST(TreeNode root, int X) {
        // Optimal - tc: O(h) sc: O(1)
        int floor=-1;
        while(root!=null){
            if(X==root.val){
                floor=root.val;
                return floor;
            }
            else if(X>root.val){
                floor=root.val;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }
}
