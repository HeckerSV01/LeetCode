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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ans[]=new ListNode[k];
        int size=0;
        ListNode temp=head;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }
        temp=head;
        if(size<=k)
        {
            for(int i=0;i<k;i++)
            {
                if(temp!=null)
                {
                    ans[i]=new ListNode(temp.val);
                    temp=temp.next;
                }
                else
                {
                    ans[i]=null;
                }
            }
        }
        else
        {
            int basesize=size/k;
            int extra=size%k;
            int extrasize=basesize+(extra==0?0:1);
            for(int i=0;i<extra;i++)
            {
                ListNode l=new ListNode(-1);
                ListNode curr=l;
                for(int j=0;j<extrasize;j++)
                {
                    curr.next=new ListNode(temp.val);
                    temp=temp.next;
                    curr=curr.next;
                }
                ans[i]=l.next;
            }
            for(int i=extra;i<k;i++)
            {
                ListNode l=new ListNode(-1);
                ListNode curr=l;
                for(int j=0;j<basesize;j++)
                {
                    curr.next=new ListNode(temp.val);
                    temp=temp.next;
                    curr=curr.next;
                }
                ans[i]=l.next;
            }
        }
        return ans;
    }
}