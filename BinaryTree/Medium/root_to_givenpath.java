// Problem link: https://www.naukri.com/code360/problems/path-in-a-tree_3843990?leftPanelTabValue=PROBLEM
public class Solution {
    public static boolean getpath(TreeNode node, List<Integer> ans, int target){
        if(node==null){
            return false;
        }
        ans.add(node.data);
        if(node.data==target){
            return true;
        }
        if(getpath(node.right,ans,target)||getpath(node.left,ans,target)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // tc: O(n) sc: O(n)
        ArrayList<Integer> ans=new ArrayList<>();
        getpath(root,ans,x);
        return ans;
        
    }
}