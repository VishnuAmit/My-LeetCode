// Problem link: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
class Solution
{
    static boolean isleaf(Node node){
        return (node.left==null) && (node.right==null);
    }
    void leftbound(Node node, List<Integer> ans){
        Node cur=node.left;
        while(cur!=null){
            if(isleaf(cur)==false) ans.add(cur.data);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    
    void rightbound(Node node, List<Integer> ans){
        Node cur=node.right;
        List<Integer> temp=new ArrayList<>();
        while(cur!=null){
            if(isleaf(cur)==false) temp.add(cur.data);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }
    
    void leafnodes(Node node, List<Integer> ans){
        if(isleaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left!=null) leafnodes(node.left,ans);
        if(node.right!=null) leafnodes(node.right,ans);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    // Optimal tc: O(n) sc: O(n)
	    ArrayList<Integer> ans=new ArrayList<>();
	    if(isleaf(node)==false) ans.add(node.data);
	    leftbound(node,ans);
	    leafnodes(node,ans);
	    rightbound(node,ans);
	    return ans;
	}
}

// clockwise
// class Solution
// {
//     static boolean isLeaf(Node node) {
//         return (node.left == null) && (node.right == null);
//     }

//     void rightBound(Node node, List<Integer> ans) {
//         Node cur = node.right;
//         while (cur != null) {
//             if (!isLeaf(cur)) ans.add(cur.data);
//             if (cur.right != null) cur = cur.right;
//             else cur = cur.left;
//         }
//     }

//     void leftBound(Node node, List<Integer> ans) {
//         Node cur = node.left;
//         List<Integer> temp = new ArrayList<>();
//         while (cur != null) {
//             if (!isLeaf(cur)) temp.add(cur.data);
//             if (cur.left != null) cur = cur.left;
//             else cur = cur.right;
//         }
//         for (int i = temp.size() - 1; i >= 0; i--) {
//             ans.add(temp.get(i));
//         }
//     }

//     void leafNodes(Node node, List<Integer> ans) {
//         if (isLeaf(node)) {
//             ans.add(node.data);
//             return;
//         }
//         if (node.right != null) leafNodes(node.right, ans);
//         if (node.left != null) leafNodes(node.left, ans);
//     }

//     ArrayList<Integer> boundary(Node node) {
//         // Optimal tc: O(n) sc: O(n)
//         ArrayList<Integer> ans = new ArrayList<>();
//         if (!isLeaf(node)) ans.add(node.data);
        
//         rightBound(node, ans); // Step 1: Traverse the right boundary
//         leafNodes(node, ans);  // Step 2: Collect all the leaf nodes
//         leftBound(node, ans);  // Step 3: Traverse the left boundary in reverse
        
//         return ans;
//     }
// }
