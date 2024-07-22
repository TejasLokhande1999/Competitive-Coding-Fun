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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next==null){
            return null;
        }

        int length=0;

        ListNode temp = head;

        while(temp!=null){
            length+=1;
            temp=temp.next;
        }

        if(n==length){
            head=head.next;
            return head;
        }
        ListNode temp2=head;
        for(int i=1;i<length-n;i++){
            temp2=temp2.next;
        }

        temp2.next = temp2.next.next;
        

        return head;

    }
}