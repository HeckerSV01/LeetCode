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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<2)
        {
            return head;
        }
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        temp=head;
        if(k==len)
        {
            return reverse(temp);
        }
        int grpno=len/k;
        ListNode res=new ListNode(0);
        ListNode ans=res;
        int i=0;
        for(i=0;i+k<=len;i=i+k)
        {
            ListNode temp1=getnode(head,i,i+k-1);
            ListNode rev=reverse(temp1);
            ans.next=rev;
            while(ans.next!=null)
            {
                ans=ans.next;
            }
        }
        temp=head;
        for(int j=0;j<i&&temp!=null;j++)
        {
            temp=temp.next;
        }
        ans.next=temp;
        return res.next;
    }
}