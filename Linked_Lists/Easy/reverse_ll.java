package Linked_Lists.Easy;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/reverse-linked-list/
class Solution {
    public ListNode reverseList(ListNode head) {
        // Brute force - tc: O(2n) sc: O(n)
        Stack<Integer> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            temp.val=st.pop();
            temp=temp.next;
        }
        return head;
        
        // iteratice - tc: O(n) sc: O(1)
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
