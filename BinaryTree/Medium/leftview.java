// PRoblem link: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
class Tree
{
    public void lefthelper(Node node, List<Integer> ans, int level){
        if(node==null){
            return;
        }
        if(ans.size()==level){
            ans.add(node.data);
        }
        lefthelper(node.left,ans,level+1);
        lefthelper(node.right,ans,level+1);
    }
    ArrayList<Integer> leftView(Node root)
    {
           // recursive - tc: O(n) sc: O(h)
        ArrayList<Integer> ans=new ArrayList<>();
        lefthelper(root,ans,0);
        return ans;
    }
}