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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(0);
        ListNode anstemp=ans;
        int carry=0;
        while(l1!=null||l2!=null)
        {
            int sum=carry;
            if(l1!=null)
            {
                sum=sum+l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum=sum+l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            anstemp.next=new ListNode(sum%10);
            anstemp=anstemp.next;
        }
        if(carry>0)
        {
            anstemp.next=new ListNode(carry);
        }
        return ans.next;
    }
}