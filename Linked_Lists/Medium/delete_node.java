package Linked_Lists.Medium;
import Linked_Lists.ListNode;
// Problem lin: https://leetcode.com/problems/delete-node-in-a-linked-list/
class Solution {
    public void deleteNode(ListNode node) {
        // Optimal - tc: O(1) sc: O(1)
        if(node==null) return;
        node.val=node.next.val;
        node.next=node.next.next;
        return;
    }
}
