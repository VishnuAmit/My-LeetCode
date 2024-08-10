// Problem link: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // tc: O(n) sc: O(n)
        Queue<Node> q=new LinkedList<>();
        Map<Integer,Integer> mpp=new TreeMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        root.hd=0;
        q.add(root);
        while(!q.isEmpty()){
            Node nd=q.poll();
            int hd=nd.hd;
            mpp.put(hd,nd.data);
            if(nd.left!=null){
                nd.left.hd=hd-1;
                q.add(nd.left);
            }
            if(nd.right!=null){
                nd.right.hd=hd+1;
                q.add(nd.right);
            }
        }
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            ans.add(entry.getValue());
        
        }
        return ans;
    }
}