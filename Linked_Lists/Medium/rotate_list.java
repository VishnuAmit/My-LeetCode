package Linked_Lists.Medium;
import Linked_Lists.ListNode;
// Problem link: https://leetcode.com/problems/rotate-list/description/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // // Brute force - tc: O(nk) sc: O(1)
        // if(head==null || head.next==null) return head;
        // for(int i=0;i<k;i++){
        //     ListNode temp=head;
        //     while(temp.next.next!=null) temp=temp.next;
        //     ListNode end=temp.next;
        //     temp.next=null;
        //     end.next=head;
        //     head=end;
        // }
        // return head;

        // Optimal - tc: O(n) sc: O(1)
        if(head==null  || head.next==null || k==0) return head;
        ListNode temp=head;
        int cnt=1;
        while(temp.next!=null){
            temp=temp.next;
            cnt++;
        }
        temp.next=head;
        k=k%cnt;
        k=cnt-k;
        while(k-->0) temp=temp.next;
        head=temp.next;
        temp.next=null; 
        return head;
    }

}
