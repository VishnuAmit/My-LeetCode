package Linked_Lists.Medium;
import Linked_Lists.ListNode;
// Problem Link: https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
class GfG
{
    public ListNode mergelists(ListNode a, ListNode b){
        ListNode temp=new ListNode(0);
        ListNode res=temp;
        while(a!=null && b!=null){
            if(a.val<b.val){
                temp.bottom=a;
                temp=temp.bottom;
                a=a.bottom;
            }else{
                temp.bottom=b;
                temp=temp.bottom;
                b=b.bottom;
            }
        }
        if(a!=null) temp.bottom=a;
        else temp.bottom=b;
        return res.bottom;
        
    }
    
    ListNode flatten(ListNode root)
    {
     // Optimal - tc: O(n) sc: O(1)
	 if(root==null || root.next==null) return root;
	 root.next=flatten(root.next);
	 root=mergelists(root,root.next);
	 return root;
	 
    }
}