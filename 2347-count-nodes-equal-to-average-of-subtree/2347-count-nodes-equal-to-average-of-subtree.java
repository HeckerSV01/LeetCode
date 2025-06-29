/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public int[] recursion(TreeNode root)
    {
        if(root==null)
        {
            return new int[]{0,0};
        }
        int l[]=recursion(root.left);
        int r[]=recursion(root.right);
        int sum=l[0]+r[0]+root.val;
        int nodes=l[1]+r[1]+1;
        if(sum/nodes==root.val)
        {
            count++;
        }
        return new int[]{sum,nodes};
    }
    public int averageOfSubtree(TreeNode root) {
        recursion(root);
        return count;
    }
}