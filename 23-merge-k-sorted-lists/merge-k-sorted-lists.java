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
        ListNode dummy = new ListNode(-1);

        ListNode curr = dummy;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator()); 
            for(ListNode list : lists){
                if(list!=null)
                    pq.add(new Pair(list,list.val));
            }
       
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                ListNode temp = p.node;
                ListNode newNode = new ListNode(temp.val);
                curr.next=newNode;
                curr=curr.next;
                temp=temp.next;
                if(temp!=null)
                    pq.add(new Pair(temp,temp.val));
            }

        
        return dummy.next;
    }
}

class Pair{
    ListNode node;
    int val;
    Pair(ListNode node, int val){
        this.node=node;
        this.val=val;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.val>p2.val){
            return 1;
        }else if(p1.val<p2.val){
            return -1;
        }else{
            return 0;
        }
    }
}