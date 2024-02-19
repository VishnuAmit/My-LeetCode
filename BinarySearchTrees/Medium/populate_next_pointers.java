package BinarySearchTrees.Medium;
import BinarySearchTrees.TreeNode;

class Solution {
    public TreeNode connect(TreeNode root) {
        // // Brute force - tc : O(n) sc: O(n)
        // if (root == null) return null;
        // Queue<Node> q = new LinkedList<>();
        // q.add(root);

        // while (!q.isEmpty()) {
        //     int n = q.size();

        //     for (int i = 0; i < n; ++i) {
        //         Node temp2 = q.poll();

        //         if (!q.isEmpty()) {
        //             temp2.next = q.peek();
        //         }
        //         if (temp2.left != null) {
        //             q.add(temp2.left);
        //         }
        //         if (temp2.right != null) {
        //             q.add(temp2.right);
        //         }
        //         if (i == n - 1) {
        //             temp2.next = null;
        //         }
        //     }
        // }

        // return root;

        // Optimal - tc: O(n) sc: O(1)
        TreeNode cur = root;
        TreeNode nxt = (root != null) ? root.left : null;

        while (cur != null && nxt != null) {
            cur.left.next = cur.right;

            if (cur.next != null) {
                cur.right.next = cur.next.left;
                cur = cur.next;
            } else {
                cur = nxt;
                nxt = cur.left;
            }
        }
        return root;
    }
}
