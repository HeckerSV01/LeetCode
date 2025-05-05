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
    public ListNode removeNodes(ListNode head) {
        ListNode temp1=head;
        ListNode temp2=head;
        int size=0;
        while(temp1!=null)
        {
            size++;
            temp1=temp1.next;
        }
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
           arr[i]=temp2.val;
           temp2=temp2.next;
        }
        int greater[]=new int[size];
        int m=arr[size-1];
        for(int i=size-1;i>=0;i--)
        {
            greater[i]=Math.max(m,arr[i]);
            m=greater[i];
        }
        ListNode res=new ListNode(-1);
        ListNode temp=res;
        for(int i=0;i<size;i++)
        {
            if(arr[i]<greater[i])
            {
               continue;
            }
            else
            {
                temp.next=new ListNode(arr[i]);
                temp=temp.next;
            }
        }
        return res.next;
    }
}