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
    public ListNode partition(ListNode head, int x) {
        ListNode temp1=new ListNode(-999);
        ListNode temp2=new ListNode(-999);
        ListNode temp3=temp1;
        ListNode temp4=temp2;
        while(head!=null)
        {
            if(head.val<x)
            {
              temp3.next=new ListNode(head.val);
              temp3=temp3.next;
              head=head.next;  
            }
            else 
            {
              temp4.next=new ListNode(head.val);
              temp4=temp4.next;
              head=head.next;
            }
        }
        temp4.next=null;
        temp3.next=temp2.next;
        return temp1.next;
    }
}