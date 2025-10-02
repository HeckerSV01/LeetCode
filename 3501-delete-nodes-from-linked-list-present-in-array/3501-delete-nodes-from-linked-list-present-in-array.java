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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        for(int k:nums)
        {
            set.add(k);
        }
        ListNode res=new ListNode(-1);
        ListNode temp=res;
        while(head!=null)
        {
            if(!set.contains(head.val))
            {
                temp.next=new ListNode(head.val);
                temp=temp.next;
            }
            head=head.next;
        }
        return res.next;
    }
}