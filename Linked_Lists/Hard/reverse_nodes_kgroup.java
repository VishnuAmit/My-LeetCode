package Linked_Lists.Hard;
import Linked_Lists.ListNode;
// Problem link: 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
		// Optimal - tc: O(n) sc: O(1)
    ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode cur=dummy,pre=dummy,nex=dummy;
		int cnt=0;
		while(cur.next!=null){
			cur=cur.next;
			cnt++;
		}
		while(cnt>=k){
			cur=pre.next;
			nex=cur.next;
			for(int i=1;i<k;i++){
				cur.next=nex.next;
				nex.next=pre.next;
				pre.next=nex;
				nex=cur.next;
			}
			pre=cur;
			cnt-=k;
		}
		return dummy.next;
    }

}
