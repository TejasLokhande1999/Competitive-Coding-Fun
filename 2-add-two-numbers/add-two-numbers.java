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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry=0;
        int sum=0;
        while(l1!=null || l2!=null){
            sum=0;
            sum=sum+carry;
            if(l1!=null){
                sum = sum+l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum = sum+l2.val;
                l2=l2.next;
            }
            int val = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(val);
            curr.next=newNode;
            curr=curr.next;
        }

        //now we reach end of list and still we have carry

        if(carry>0)
        {
            ListNode newNode = new ListNode(carry);
            curr.next=newNode;
            curr=curr.next;
        }
        curr = dummy.next;
        return curr;
    }
}