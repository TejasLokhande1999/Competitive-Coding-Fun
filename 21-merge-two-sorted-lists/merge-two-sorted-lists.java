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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = null;
        ListNode curr = null;
        while(list1!=null && list2!=null){

            if(list1.val==list2.val){
                ListNode newNode = new ListNode(list1.val);
                list1 = list1.next;
                if(head==null){
                    head = newNode;
                    curr = head;
                }else{
                    curr.next=newNode;
                    curr = curr.next;
                }
            }else if(list1.val<list2.val){
                ListNode newNode = new ListNode(list1.val);
                list1 = list1.next;
                if(head==null){
                    head = newNode;
                    curr = head;
                }else{
                    curr.next=newNode;
                    curr = curr.next;
                }
            }else{
                ListNode newNode = new ListNode(list2.val);
                list2 = list2.next;
                if(head==null){
                    head = newNode;
                    curr = head;
                }else{
                    curr.next=newNode;
                    curr = curr.next;
                }
            }

        }

        while(list1!=null){
            ListNode newNode = new ListNode(list1.val);
            if(head==null){
                head = newNode;
                curr=head;
            }else{
                curr.next=newNode;
                curr =curr.next;
            }
            list1 = list1.next;
        }

         while(list2!=null){
            ListNode newNode = new ListNode(list2.val);
            if(head==null){
                head = newNode;
                curr=head;
            }else{
                curr.next=newNode;
                curr =curr.next;
            }
            list2 = list2.next;

        }

        return head;
    }
}