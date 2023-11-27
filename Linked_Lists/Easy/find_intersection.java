package Linked_Lists.Easy;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/intersection-of-two-linked-lists/
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // // Brute force - tc: O(nm) sc: O(1)
        // while(headB!=null){
        //     ListNode temp=headA;
        //     while(temp!=null){
        //         if(temp==headB) return headB;
        //         temp=temp.next;
        //     }
        //     headB=headB.next;
        // }
        // return null;

        // // Better - tc: O(n+m) sc: O(n)
        // HashSet<ListNode> set=new HashSet<>();
        // while(headA!=null){
        //     set.add(headA);
        //     headA=headA.next;
        // }
        // while(headB!=null){
        //     if(set.contains(headB)){
        //         return headB;
        //     }
        //     headB=headB.next;
        // }
        // return null;

        // Optimal - tc: O(2max(m,n)) sc: O(1)
        ListNode d1=headA;
        ListNode d2=headB;
        while(d1!=d2){
            d1=d1==null ? headB : d1.next;
            d2=d2==null ? headA : d2.next;
        }
        return d1;
}
}