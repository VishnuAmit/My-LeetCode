// Problem link: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
class Pair{
    int hd;
    Node node;
    Pair(Node node, int hd){
        this.node=node;
        this.hd=hd;
    }
}
class Solution {
 
    static ArrayList<Integer> topView(Node root) {
        // tc: O(n) sc: O(n)
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> mpp=new TreeMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        // root.hd=0;
        // q.add(root);
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            // Node nd=q.poll();
            // int hd=nd.hd;
            Pair it=q.poll();
            int hd=it.hd;
            Node nd=it.node;
            if(mpp.get(hd)==null) mpp.put(hd,nd.data);
            if(nd.left!=null){
                // nd.left.hd=hd-1;
                // q.add(nd.left);
                q.add(new Pair(nd.left,hd-1));
            }
            if(nd.right!=null){
                // nd.right.hd=hd+1;
                // q.add(nd.right);
                q.add(new Pair(nd.right,hd+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            ans.add(entry.getValue());
        
        }
        return ans;
    }
}