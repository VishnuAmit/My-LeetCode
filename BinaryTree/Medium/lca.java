// Problem link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
class Solution {

    public boolean helper(TreeNode node, List<TreeNode> ans, TreeNode target) {
        if (node == null) {
            return false;
        }
        ans.add(node);
        if (node == target) {
            return true;
        }
        if (helper(node.left, ans, target) || helper(node.right, ans, target)) {
            return true;
        }
        ans.remove(ans.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Brute force - tc: O(2n) sc: O(2n)
        ArrayList<TreeNode> ans1 = new ArrayList<>();
        ArrayList<TreeNode> ans2 = new ArrayList<>();

        TreeNode lca = null;
        if (!helper(root, ans1, p) || !helper(root, ans2, q)) {
            return null;
        }
        for (int i = 0; i < Math.min(ans1.size(), ans2.size()); i++) {
            if (ans1.get(i) == ans2.get(i)) {
                lca = ans1.get(i); // Update LCA
            } else {
                break; // Paths diverge
            }
        }
        // // Optimal - tc: O(n) sc: O(n)
        // if(root==null || root==p || root==q) return root;

        // TreeNode left=lowestCommonAncestor(root.left,p,q);
        // TreeNode right=lowestCommonAncestor(root.right,p,q);

        // if(left==null){
        // return right;
        // }
        // else if(right==null){
        // return left;
        // }
        // else{
        // return root;
        // }

        return lca;
    }
}
