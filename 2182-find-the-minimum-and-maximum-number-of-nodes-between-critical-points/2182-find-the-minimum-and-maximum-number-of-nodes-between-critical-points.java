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
    public int[] nodesBetweenCriticalPoints(ListNode head){
        if(head==null||head.next==null||head.next.next==null)
        {
            return new int[]{-1,-1};
        }
        List<Integer> crit=new ArrayList<>();
        ListNode temp=head;
        ListNode prev=null;
        int idx=0;
        while(temp!=null&&temp.next!=null)
        {
            if(prev!=null)
            {
                if(prev.val>temp.val&&temp.val<temp.next.val||prev.val<temp.val&&temp.val>temp.next.val)
                {
                    crit.add(idx);
                }
            }
            prev=temp;
            temp=temp.next;
            idx++;
        }
        if(crit.size()<2)
        {
            return new int[]{-1,-1};
        }
        int maxdis=crit.get(crit.size()-1)-crit.get(0);
        int mindis=Integer.MAX_VALUE;
        for(int i=1;i<crit.size();i++)
        {
            mindis=Math.min(mindis,crit.get(i)-crit.get(i-1));
        }
        return new int[]{mindis,maxdis};
    }
}