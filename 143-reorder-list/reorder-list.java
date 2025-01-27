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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast = slow.next;
        int slowCount =0;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            slowCount++;
        }
        
        ListNode temp = slow.next;
        slow.next = null;

        //Now get the head of new LL

        ListNode head2 = getHead(temp);
        ListNode head1 = head;

        while(head2!=null){

            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;
            
            head1 = next1;
            head2 = next2;

        }
    }

    public ListNode getHead(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}