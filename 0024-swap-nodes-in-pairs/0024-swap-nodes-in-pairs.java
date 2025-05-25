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
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode getnode(ListNode head,int i,int j)
    {
        ListNode temp=head;
        ListNode n=new ListNode(0);
        ListNode n1=n;
        for(int k=0;k<i;k++)
        {
            temp=temp.next;
        }
        for(int k=i;k<=j;k++)
        {
            if(temp==null)
            {
                break;
            }
            n1.next=new ListNode(temp.val);
            temp=temp.next;
            n1=n1.next;
        }
        return n.next;
    }
    public ListNode swapPairs(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        if(head==null||len<2)
        {
            return head;
        }
        temp=head;
        if(len==2)
        {
            return reverse(head);
        }
        ListNode res=new ListNode(0);
        ListNode r=res;
        int i=0;
        for(i=0;i<=len-2;i=i+2)
        {
            ListNode temp1=getnode(head,i,i+1);
            ListNode rev=reverse(temp1);
            r.next=rev;
            while(r.next!=null)
            {
                r=r.next;
            }
        }
        temp=head;
        for(int j=0;j<i&&temp!=null;j++)
        {
            temp=temp.next;
        }
        r.next=temp;
        return res.next;
    }
}