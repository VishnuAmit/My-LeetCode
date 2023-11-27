package Linked_Lists.Medium;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/linked-list-cycle-ii/
class Solution {
    public ListNode detectCycle(ListNode head) {
    //    // Brute force - tc: O(n) sc: O(n)
    //    HashSet<ListNode> set=new HashSet<>();
    //    while(head!=null){
    //        if(set.contains(head)) return head;
    //        set.add(head);
    //        head=head.next;
    //    }
    //    return null;

    // Optimal 
    ListNode fast=head;
    ListNode slow=head;
    while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
        if(slow==fast){
            fast=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
    }
    return null;
   
    }
}
