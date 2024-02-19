// Problem link: https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1
package BinarySearchTrees;
import BinarySearchTrees.TreeNode;
class Solution {
    class NodeWrapper {
        TreeNode node;
    }

    public TreeNode helper(TreeNode root, NodeWrapper head, NodeWrapper prev) {
        if (root == null)
            return null;

        helper(root.left, head, prev);

        if (head.node == null) {
            head.node = root;
        } else {
            prev.node.right = root;
            root.left = prev.node;
        }

        prev.node = root;

        helper(root.right, head, prev);

        return head.node;
    }

    public TreeNode bToDLL(TreeNode root) {
        NodeWrapper head = new NodeWrapper();
        NodeWrapper prev = new NodeWrapper();
        helper(root, head, prev);
        return head.node;
    }
}