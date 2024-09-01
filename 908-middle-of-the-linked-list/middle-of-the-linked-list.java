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
    public ListNode middleNode(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }

        return slow;

        // int count=0;
        // ListNode temp = head;

        // while(temp!=null){
        //     count+=1;
        //     temp = temp.next;
        // }

        // count = (count/2)+1;
        // ListNode temp2=head;
        // for(int i=0;i<count-1;i++){
        //     temp2=temp2.next;
            
        // }

        // return temp2;

    }
}