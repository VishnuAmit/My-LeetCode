// Problem link: https://www.naukri.com/code360/problems/981269?topList=striver-sde-sheet-problems&leftPanelTabValue=PROBLEM

import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node=node;
        this.num=num;
    }
}


public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // tc: O(3n) sc: O(4n)
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        Stack<Pair> st=new Stack<>();
        if(root==null) return null;
        st.add(new Pair(root,1));

        while(!st.isEmpty()){
            Pair temp=st.pop();
            if(temp.num==1){
                pre.add(temp.node.data);
                temp.num++;
                st.push(temp);
                if(temp.node.left!=null){
                    st.push(new Pair(temp.node.left,1));
                }
            }else if(temp.num==2){
                in.add(temp.node.data);
                temp.num++;
                st.push(temp);
                if(temp.node.right!=null){
                    st.push(new Pair(temp.node.right,1));
                }
            }else{
                post.add(temp.node.data);
            }
        }

        List<List<Integer>> result=new ArrayList<>();
        result.add(in);
        result.add(pre);
        result.add(post);
        return result;
    }
}