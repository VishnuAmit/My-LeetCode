package Linked_Lists.Medium;
import Linked_Lists.ListNode;
// Problem link: 
class Solution {
    public ListNode copyRandomList(ListNode head) {
        // // Brute force - tc: O(2n) sc: O(1)
        // HashMap<Node,Node> mpp=new HashMap<>();List
        // Node temp=head;
        // while(temp!=null){
        //     Node newnode = new Node(temp.val);
        //     mpp.put(temp,newnode);
        //     temp=temp.next;
        // }
        // Node t=head;
        // while(t!=null){
        //     Node node=mpp.get(t);
        //     node.next=(t.next!=null) ? mpp.get(t.next) : null;
        //     node.random=(t.random!=null) ? mpp.get(t.random) : null;
        //     t=t.next;
        // }
        // return mpp.get(head);

        // Optimal - tc: O(3n) sc: O(1)
        ListNode temp=head;
        while(temp!=null){
            ListNode newnode =new ListNode(temp.val);
            newnode.next=temp.next;
            temp.next=newnode;
            temp=temp.next.next;
        }

        ListNode itr=head;
        while(itr!=null){
            if(itr.random!=null){
                itr.next.random=itr.random.next;
            }
            itr=itr.next.next;
        }
        
        ListNode dummy=new ListNode(0);
        itr=head;
        temp=dummy;
        ListNode front;
        while(itr!=null){
            front=itr.next.next;
            temp.next=itr.next;
            itr.next=front;
            temp=temp.next;
            itr=front;
        }
        return dummy.next;

    }
}
