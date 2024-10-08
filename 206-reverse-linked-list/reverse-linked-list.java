/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    if(head==null){
        return null;
    }

    ListNode node = head;
    ListNode prev=null;
    ListNode front = null;

    while(node!=null){
        front=node.next;
        node.next=prev;
        prev=node;
        node=front;
    }

    return prev;
 
    }
}