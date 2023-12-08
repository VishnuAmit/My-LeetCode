package Linked_Lists.Easy;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/middle-of-the-linked-list/
class Solution {
    public ListNode middleNode(ListNode head) {
        // // Brute force - tc: O(n+n/2) sc: O(1)
        // int cnt=0;
        // ListNode current=head;
        // while(current!=null){
        //     current=current.next;
        //     cnt++;
        // }
        // current=head;
        // for(int i=0;i<cnt/2;i++){
        //     current=current.next;
        // }
        // return current;

        // Optimal - tc: O(n/2) sc: O(1)
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}