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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
        {
            return head;
        }
        ListNode temp1,temp2,temp3;
        temp1=temp2=head;
        int count=1;
        while(temp1.next!=null)
        {
          count++;
          temp1=temp1.next;
        }
        k=k%count;
        if(k==0)
        {
            return head;
        }
        for(int i=0;i<count-k-1;i++)
        {
            temp2=temp2.next;
        }
        temp3=temp2.next;
        temp2.next=null;
        temp1.next=head;
        return temp3;
    }
}