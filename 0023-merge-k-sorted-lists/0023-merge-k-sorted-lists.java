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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<lists.length;i++)
        {
            ListNode temp=lists[i];
            while(temp!=null)
            {
                a.add(temp.val);
                temp=temp.next;
            }
        }
        Collections.sort(a);
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        for(int i=0;i<a.size();i++)
        {
            temp.next=new ListNode(a.get(i));
            temp=temp.next;
        }
        return ans.next;
    }
}