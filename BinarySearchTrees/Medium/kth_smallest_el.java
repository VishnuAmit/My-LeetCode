package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;
// Problem link: https://www.codingninjas.com/studio/problems/920441?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
class Solution {
    private static int res = 0;
    private static int cnt = 0;

    public static int kthSmallest(TreeNode root, int k) {
        // Optimal - tc: O(n) sc: O(1)
        traverse(root, k);
        return res;
    }

    private static void traverse(TreeNode root, int k) {
        if (root == null || cnt >= k) {
            return;
        }
        traverse(root.left, k);
        cnt++;
        if (cnt == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}

