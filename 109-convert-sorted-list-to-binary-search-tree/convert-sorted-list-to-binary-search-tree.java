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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null){
            return null;
        }
        int size = 0;
        ListNode node = head;

        while(node!=null){
            size+=1;
            node=node.next;
        }

        int nums[] = new int[size];
        node = head;
        int i=0;
         while(node!=null){
            nums[i] = node.val;
            i++;
            node=node.next;
        }

        return helper(nums,0,size-1);
    }

    public TreeNode helper(int nums[], int l, int r){

        if (l > r) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, l, m - 1);
        root.right = helper(nums, m + 1, r);
        return root;
        

    }
}