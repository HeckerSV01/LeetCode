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
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt;
        while(curr!=null)
        {
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        head=prev;
        return head;
    }
}