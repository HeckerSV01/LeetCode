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
    public void reorderList(ListNode head) {
        ListNode slow,fast;
        slow=fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second;
        second=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(second!=null)
        {
            ListNode nxt=second.next;
            second.next=prev;
            prev=second;
            second=nxt;
        }
        second=prev;
        ListNode first=head;
        while(second!=null)
        {
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;//new value of first for next round of while
            second=temp2;
        }
    }
}