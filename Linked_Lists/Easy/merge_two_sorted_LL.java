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
    ListNode dummy=new ListNode(0);
    ListNode temp=dummy;
    ListNode t1=list1;
    ListNode t2=list2;

    while(t1!=null && t2!=null){
        if(t1.val<t2.val){
            temp.next=t1;
            temp=t1;
            t1=t1.next;
        }else{
            temp.next=t2;
            temp=t2;
            t2=t2.next;
        }
    }
    if(t1!=null) temp.next=t1;
    if(t2!=null) temp.next=t2;
    return dummy.next;
    }
}
