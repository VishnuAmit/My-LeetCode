package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;
// Problem link: https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
class Solution{
    static TreeNode suc;
    static TreeNode pre;
public static void findPreSuc(TreeNode root, int key)
    // tc: O(h) sc: O(1)
    {
        successor(root, key);
        predecessor(root, key);
    }
    static void successor(TreeNode root,int key){
        if(root==null)
            return;
        if(root.val<=key)
        {
            successor(root.right,key);
        }
        else {
              suc=root;
              successor(root.left,key);
        }
    }
    static void predecessor(TreeNode root,int key){
        if(root==null)
            return;
        if(root.val>=key)
        {
            predecessor(root.left, key);
        }
        else {
      
            pre=root;
            predecessor(root.right,key);
        }
    }
}

