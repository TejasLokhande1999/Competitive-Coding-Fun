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
            break;
        }else{
            ListNode nextGrpStart = kthNode.next;
            kthNode.next=null;

            reverse(currStart);

            prevGrpEnd.next = kthNode;
            currStart.next = nextGrpStart;
            prevGrpEnd = currStart;
            currStart=currStart.next;
        }

        }
        return dummy.next;


    }


    public ListNode getKthNode(ListNode node, int k){
        ListNode temp = node;

        while(temp!=null && k>1){
            k--;
            temp=temp.next;
        }

        return temp;
    }

    public ListNode reverse(ListNode node){

        ListNode prev=null;
        ListNode front = null;

        while(node!=null){
            front = node.next;
            node.next=prev;
            prev = node;
            node = front;
        }

        return prev;
    }


}