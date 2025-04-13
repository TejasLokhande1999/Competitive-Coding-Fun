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
        
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);

        int sum=0;
        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(head1!=null && head2!=null){

            int num1 = head1.val;
            int num2 = head2.val;

            sum = num1+num2+carry;

            if(sum>=10){
                sum = sum%10;
                carry=1;
            }else{
                carry=0;
            }

            ListNode newNode = new ListNode(sum);
            curr.next = newNode;
            curr = newNode;
            head1 = head1.next;
            head2 = head2.next;

        }

        while(head1!=null){
            int num1 = head1.val;
            sum = num1+carry;
            if(sum>=10){
                sum = sum%10;
                carry=1;
            }else{
                carry=0;
            }
            ListNode newNode = new ListNode(sum);
            curr.next = newNode;
            curr = newNode;
        
            head1 = head1.next;
        }

        while(head2!=null){
            int num2 = head2.val;
            sum = num2+carry;
            if(sum>=10){
                sum = sum%10;
                carry=1;
            }else{
                carry=0;
            }
            ListNode newNode = new ListNode(sum);
            curr.next = newNode;
            curr = newNode;
        
            head2 = head2.next;
        }

        if(carry>0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }

        ListNode head = dummy.next;
        dummy.next = null;

        head = reverse(head);
        return head;
        


    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}