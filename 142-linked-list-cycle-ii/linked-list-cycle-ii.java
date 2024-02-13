/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<ListNode>();
        ListNode node = head;
        int counter=0;
        while(node!=null)
        {
            if(!set.contains(node))
            {   
                set.add(node);
                node = node.next;
                counter++;
            }else{
                return node;
            }
        }

        return node;


    }
}