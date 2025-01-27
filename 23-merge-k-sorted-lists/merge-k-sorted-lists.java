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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());

        for(ListNode list : lists){
            if(list!=null)
                pq.add(list);
            
        }

        ListNode head = null;
        ListNode curr = null;

        while(!pq.isEmpty()){

            ListNode node = pq.poll();
            ListNode newNode = new ListNode(node.val);
            if(head==null){
                head = newNode;
                curr = newNode;
            }else{

                curr.next = newNode;
                curr = curr.next;
            }

            if(node.next!=null){
                pq.add(node.next);
            }

        }

        return head;
    }
}

class ListNodeComparator implements Comparator<ListNode>{

    public int compare(ListNode l1, ListNode l2){

        if(l1.val>l2.val){
            return 1;
        }else if(l1.val<l2.val){
            return -1;
        }else{
            return 0;
        }

    }

}