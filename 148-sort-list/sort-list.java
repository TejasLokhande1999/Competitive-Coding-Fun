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
    public ListNode sortList(ListNode head) {
//        Set<Integer> set = new TreeSet<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode node = head;

        while(node!=null)
        {
            list.add(node.val);
            node = node.next;
        }

        ListNode newNode = null;
        ListNode newHead = null;
        int counter=0;
        Collections.sort(list);
    for(int i : list)
    {
        if(counter==0)
        {
            newHead = new ListNode(i);
            newNode = newHead;
            newNode.next =null;
            counter++;
        }else{
            ListNode nodeNew = new ListNode(i);
            newNode.next = nodeNew;
            newNode = newNode.next;
        }
    }

    return newHead;

    }
}