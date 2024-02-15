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
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new LinkedHashSet<Integer>();     
        ListNode node = head;
        while(node!=null)
        {
            if(!set.contains(node.val))
                set.add(node.val);
            node= node.next;
        }

    ListNode headNew=null;
    ListNode nodeNew=null;
    int counter=0;
    for(int i : set)
    {
        if(counter==0)
        {
            headNew = new ListNode(i);
            nodeNew = headNew;
            headNew.next=null;
            counter++;
        }else{
            ListNode newNode = new ListNode(i);
            nodeNew.next = newNode;
            nodeNew = nodeNew.next;
        }
    }

    return headNew;

    }
}