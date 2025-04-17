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
    public ListNode delfirst(ListNode head)
    {
        head=head.next;
        return head;
    }
    public ListNode delend(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return null;
        }
        ListNode temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=1;
        while(temp.next!=null)
        {
            size++;
            temp=temp.next;
        }
        int k=size-n-1;
        if(n==1)
        {
            return delend(head);
        }
        else if(n==size)
        {
            return delfirst(head);
        }
            ListNode temp2=head;
            for(int i=1;i<=k;i++)
            {
                temp2=temp2.next;
            }
            temp2.next=temp2.next.next;
                return head;
    }
}