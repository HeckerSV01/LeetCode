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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=-1;
            }
        }
        int rowst=0;
        int rowen=m-1;
        int colst=0;
        int colen=n-1;
        while(head!=null)
        {
            for(int i=colst;i<=colen&&head!=null;i++)
            {
               arr[rowst][i]=head.val;
               head=head.next;
            }
            rowst++;
            for(int i=rowst;i<=rowen&&head!=null;i++)
            {
                arr[i][colen]=head.val;
                head=head.next;
            }
            colen--;
            for(int i=colen;i>=colst&&head!=null;i--)
            {
                arr[rowen][i]=head.val;
                head=head.next;
            }
            rowen--;
            for(int i=rowen;i>=rowst&&head!=null;i--)
            {
                arr[i][colst]=head.val;
                head=head.next;
            }
            colst++;
        }
        return arr;
    }
}