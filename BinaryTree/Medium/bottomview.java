// Problem link: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
class Pair{
    Node node;
    int hd;
    public Pair(Node node, int hd){
        this.node=node;
        this.hd=hd;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        //  tc: O(n) sc: O(n)
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> mpp=new TreeMap<>();
        Node node=root;
        q.add(new Pair(node,0));
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            Pair it=q.poll();
            Node nd=it.node;
            int hd=it.hd;
            
            mpp.put(hd,nd.data);
            
            if(nd.left!=null){
                q.add(new Pair(nd.left,hd-1));
            }
            if(nd.right!=null){
                q.add(new Pair(nd.right,hd+1));
            }
        }
        
        for(Map.Entry<Integer,Integer> itr: mpp.entrySet()){
            ans.add(itr.getValue());
        }
        
        return ans;
    }
}
