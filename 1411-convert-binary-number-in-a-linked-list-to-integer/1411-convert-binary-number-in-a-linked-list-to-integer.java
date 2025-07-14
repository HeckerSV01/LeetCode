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
    public int getDecimalValue(ListNode head) {
        int nodes=0;
        ListNode temp=head;
        while(temp!=null)
        {
            nodes++;
            temp=temp.next;
        }
        double res=0;
        temp=head;
        for(int i=0;i<nodes;i++)
        {
            res=res+temp.val*Math.pow(2,nodes-i-1);
            temp=temp.next;
        }
        return (int)res;
    }
}