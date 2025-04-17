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
    public int[] nextLargerNodes(ListNode head) {
        int size=1;
        ListNode temp1=head;
        while(temp1.next!=null)
        {
            size++;
            temp1=temp1.next;
        }
        int arr[]=new int[size];
        int res[]=new int[size];
        ListNode temp2=head;
        for(int i=0;i<size;i++)
        {
            arr[i]=temp2.val;
            temp2=temp2.next;
        }
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!s.isEmpty()&&arr[s.peek()]<=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                res[i]=0;
            }
            else
            {
                res[i]=arr[s.peek()];
            }
            s.push(i);
        }
      return res;
    }
}