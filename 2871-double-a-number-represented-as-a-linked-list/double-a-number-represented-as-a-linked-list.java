 import java.math.BigInteger;
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
    public ListNode doubleIt(ListNode head) {
        
        String str= "";
        ListNode node123 = head;

        while(node123!=null){
            str+=String.valueOf(node123.val);
            node123 = node123.next;
        }

     //   long number = Long.parseLong(str);
       // number=number*2;

        BigInteger number = new BigInteger(str);
     //   BigInteger number2 = new BigInteger(2);
     number = number.multiply(BigInteger.valueOf(2));

        //number = number*2;

        ListNode headNode= null;
        ListNode curr = new ListNode();

        String traceStr = String.valueOf(number);
        System.out.println(number);

        for(int i=0;i<traceStr.length();i++){
            char ch = traceStr.charAt(i);
            //int val = Integer.parseInt(traceStr.charAt(i));
            int val=Character.getNumericValue(ch);  
            if(headNode==null){
                ListNode node = new ListNode(val);
                headNode = node;
            }else{
                ListNode node1 = headNode;
                while(node1.next!=null){
                    node1 = node1.next;
                }

                ListNode newNode = new ListNode(val);
                node1.next=newNode;
            }
        }

        return headNode;


    }
}