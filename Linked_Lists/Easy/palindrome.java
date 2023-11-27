package Linked_Lists.Easy;
// Problem link: https://leetcode.com/problems/palindrome-linked-list/
import Linked_Lists.ListNode;
class Solution {
    public ListNode reverse(ListNode head){
        ListNode dummy=null;
        while(head!=null){
            ListNode nex=head.next;
            head.next=dummy;
            dummy=head;
            head=nex;
        }
        return dummy;
    }
    public boolean isPalindrome(ListNode head) {
    // // Brute force - tc: O(n) sc: O(n)
    // ArrayList<Integer> ans=new ArrayList<>();
    // while(head!=null){
    //     ans.add(head.val);
    //     head=head.next;
    // }
    // for(int i=0;i<ans.size()/2;i++){
    //     if(ans.get(i)!=ans.get(ans.size()-1-i)) return false; 
    // }
    // return true;

    // Optimal - tc: O(3n/2) sc: O(1)
    if(head==null || head.next==null) return true;
    ListNode fast=head;
    ListNode slow=head;
    while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    slow.next=reverse(slow.next);
    slow=slow.next;
    ListNode dummy=head;
    while(slow!=null){
        if(slow.val!=dummy.val) return false;
        slow=slow.next;
        dummy=dummy.next;
    }
    return true;
    }
}