/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2=0;

        ListNode temp1  = headA;
        ListNode temp2 = headB;

        while(temp1!=null){
            l1++;
            temp1=temp1.next;
        }

        while(temp2!=null){
            l2++;
            temp2=temp2.next;
        }

        int d= Math.abs(l1-l2);

        if(l1>l2){
            ListNode node = headA;
            int count=0;
            while(count<d){
                count++;
                node=node.next;
            }
            return getIntersection(node,headB);
        }else{
            ListNode node = headB;
            int count=0;
            while(count<d){
                count++;
                node=node.next;
            }

            return getIntersection(headA,node);

        }

    }

    public ListNode getIntersection(ListNode headA, ListNode headB){
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=null && temp2!=null){
            if(temp1.equals(temp2)){
                return temp1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }

        return null;
    }

}