package Linked_Lists.Easy;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/linked-list-cycle/
class Solution {
    public boolean hasCycle(ListNode head) {
        // // Brute force - tc: O(n) sc: O(n)
        // HashSet<ListNode> set=new HashSet<>();
        // while(head!=null){
        //     if(set.contains(head)) return true;
        //     set.add(head);
        //     head=head.next;
        // }
        // return false;

        // Optimal - tc: O(n) sc: O(1)
        ListNode fast=head;
        ListNode slow=head;
        if(head==null || head.next==null) return false;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
}