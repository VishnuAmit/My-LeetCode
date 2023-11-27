package Linked_Lists.Medium;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // // Brute force - tc: O(2n) sc: O(1)
        // ListNode current=head;
        // int cnt=0;
        // while(current!=null){
        //     current=current.next;
        //     cnt++;
        // }
        // int target=cnt-n;
        // if(target==0) return head.next;
        // current = head;
        // for(int i=0;i<target-1;i++){
        //     current=current.next;
        // }
        // current.next=current.next.next;
        // return head;

        // Optimal - tc: O(n) sc: O(1)
        ListNode start=new ListNode();
        start.next=head;
        ListNode fast=start;
        ListNode slow=start;
        for(int i=1;i<=n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return start.next;
        
    }
}