// Problem link: https://leetcode.com/problems/binary-tree-right-side-view/
class Solution {
    public void righthelper(TreeNode node, List<Integer> ans, int level){
        if(node==null){
            return;
        }
        if(ans.size()==level){
            ans.add(node.val);
        }
        righthelper(node.right,ans,level+1);
        righthelper(node.left,ans,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        // recursive - tc: O(n) sc: O(h)
        List<Integer> ans=new ArrayList<>();
        righthelper(root,ans,0);
        return ans;

    }
}