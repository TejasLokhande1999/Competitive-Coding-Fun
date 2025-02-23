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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            if(node!=null)
                pq.add(node);
        }

        ListNode head = null;
        ListNode node = null;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();

            if(head==null){
                head = temp;
                node = head;
            }else{
                node.next=temp;
                node = temp;
            }

            temp=temp.next;
            if(temp!=null){
                pq.add(temp);
            }
        }

        return head;
    }
}