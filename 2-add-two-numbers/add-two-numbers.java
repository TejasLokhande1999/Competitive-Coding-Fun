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

        int sum=0;
        int carry=0;

        while(l1!=null  || l2!=null){

            sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            if(carry==1){
                sum+=1;
            }
            int val = sum%10;
            carry = sum/10;

            ListNode node = new ListNode(val);
            curr.next = node;
            curr = curr.next;

        }

        if(carry>0){
            ListNode node = new ListNode(1);
            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;

    }
}