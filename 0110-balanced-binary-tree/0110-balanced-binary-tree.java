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
    public static int recursion(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int rh=recursion(root.right);
        int lh=recursion(root.left);
        if(Math.abs(rh-lh)>1||lh==-1||rh==-1)
        {
            return -1;
        }
        return Math.max(rh,lh)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(recursion(root)==-1)
        {
            return false;
        }
        return true;
    }
}