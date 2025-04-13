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
       ListNode temp = dummy;

       int carry = 0;
       int sum=0;
       while(l1!=null && l2!=null){

            int num1 = l1.val;
            int num2 = l2.val;

            sum = num1+num2+carry;

            if(sum>9){
                sum = sum%10;
                carry=1;
            }else{
                carry =0;
            }

            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
            l1 = l1.next;
            l2 = l2.next;

       }

        while(l1!=null){
            
        int num1 = l1.val;
        sum = num1+carry;
        if(sum>9){
                sum = sum%10;
                carry=1;
        }else{
                carry =0;
        }
        ListNode newNode = new ListNode(sum);
        temp.next = newNode;
        temp = newNode;
        l1 = l1.next;

        }

        while(l2!=null){
            
        int num2 = l2.val;
        sum = num2+carry;
        if(sum>9){
                sum = sum%10;
                carry=1;
        }else{
                carry =0;
        }
        ListNode newNode = new ListNode(sum);
        temp.next = newNode;
        temp = newNode;
        l2 = l2.next;

        }

        if(carry>0){
        ListNode newNode = new ListNode(carry);
        temp.next = newNode;
        }

        return dummy.next;

    }
}