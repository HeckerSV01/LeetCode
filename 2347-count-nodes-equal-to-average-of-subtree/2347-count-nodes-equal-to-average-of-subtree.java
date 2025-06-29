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
    public int nodes(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lc=nodes(root.left);
        int rc=nodes(root.right);
        return lc+rc+1;
    }
    public int sum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lsum=sum(root.left);
        int rsum=sum(root.right);
        return lsum+rsum+root.val;
    }
    public boolean check(TreeNode root)
    {
        int s=sum(root);
        int n=nodes(root);
        if(s/n==root.val)
        {
            return true;
        }
        return false;
    }
    public void traverse(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        if(check(root))
        {
            count++;
        }
        traverse(root.left);
        traverse(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return count;
    }
}