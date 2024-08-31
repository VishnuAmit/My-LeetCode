// Problem link: https://www.naukri.com/code360/problems/childrensumproperty_790723?leftPanelTabValue=PROBLEM
public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        // Optimal - tc: O(n) sc: O(n)
        if(root==null) return;
        int cnt=0;
        if(root.left!=null){
            cnt+=root.left.data;
        }
        if(root.right!=null){
            cnt+=root.right.data;
        }

        if(cnt>=root.data){
            root.data=cnt;
        }else{
            if(root.left!=null) root.left.data=root.data;
            if(root.right!=null) root.right.data=root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot=0;
        if(root.left!=null) tot+=root.left.data;
        if(root.right!=null) tot+=root.right.data;
        if(root.left!=null || root.right!=null ) root.data=tot;
    }
}