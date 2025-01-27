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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(-1);
        ListNode prevGrpEnd = dummy;

        ListNode currStart = head;

        while(currStart!=null){

            ListNode kthNode = getKthNode(currStart,k);

            if(kthNode==null){
                prevGrpEnd.next=currStart;
                return dummy.next;
            }
            ListNode nextGrpStart = kthNode.next;
            kthNode.next = null;

            reverse(currStart);

            prevGrpEnd.next = kthNode;
            currStart.next = nextGrpStart;
            prevGrpEnd = currStart;
            currStart = currStart.next;

        }

        return dummy.next;

    }

    public ListNode getKthNode(ListNode temp, int k){

        ListNode node = temp;
        int count=1;

        while(node!=null && count<k){
            count++;
            node = node.next;
        }

        return node;
    }

    public void reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

    }
}