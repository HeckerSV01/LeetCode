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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1,temp2;
        temp1=temp2=head;
        for(int i=1;i<k;i++)
        {
           temp1=temp1.next;
        }
      ListNode temp3=temp1;
      while(temp1.next!=null)
      {
        temp1=temp1.next;
        temp2=temp2.next;
      }
      int temp=temp3.val;
      temp3.val=temp2.val;
      temp2.val=temp;
      return head;
    }
}