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
    Random r=new Random();
    ArrayList<Integer> list;
    public Solution(ListNode head) {
        list=new ArrayList<>();
        ListNode temp=head;
        
        while(temp!=null)
        {
            list.add(temp.val);
            temp=temp.next;
        }
    }
    public int getRandom() {
        int rand=r.nextInt(list.size());
        return list.get(rand);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */