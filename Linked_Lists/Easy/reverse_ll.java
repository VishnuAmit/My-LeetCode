package Linked_Lists.Easy;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/reverse-linked-list/
class Solution {
    public ListNode reverseList(ListNode head) {
        // recursive - tc: O(n) sc: O(1)
        ListNode dummy = null;
        while(head!=null){
        ListNode next=head.next;
        head.next=dummy;
        dummy=head;
        head=next;
        }
        return dummy;
    }
}
