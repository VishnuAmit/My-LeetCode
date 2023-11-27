package Linked_Lists.Easy;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //   // Brute foce - tc: O(n1+n2) sc: O(n1+n2)
    //   ListNode dummy=new ListNode(0);
    //   ListNode current=dummy;
    //   while(list1!=null && list2!=null){
    //       if(list1.val<list2.val){
    //         current.next=list1;
    //         list1=list1.next;
    //     }else{
    //         current.next=list2;
    //         list2=list2.next;
    //     }
    //      current = current.next;
    //   }
    //   if(list1!=null){
    //         current.next=list1;
    //   }
    //   else if(list2!=null){
    //         current.next=list2;
    //   }
    // return dummy.next;

    // Optimal - tc: O(n+m) sc: O(1)
    if(list1==null) return list2;
    if(list2==null) return list1;
    if(list1.val>list2.val){
        ListNode temp=list1;
        list1=list2;
        list2=temp;
    }
    ListNode res=list1;
    while(list1!=null && list2!=null){
        ListNode tmp= null;
        while(list1!=null && list1.val<=list2.val){
            tmp=list1;
            list1=list1.next;
        }
        tmp.next=list2;
        tmp=list2;
        list2=list1;
        list1=tmp;
    }
    return res;
    }
}
