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
    boolean check=true;
    public boolean traverse(TreeNode root,long min,long max)
    {
        if(root==null)
        {
            return true;
        }
        if(root.val>=max||root.val<=min)
        {
            return false;
        }
        return traverse(root.left,min,root.val)&&traverse(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return traverse(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}