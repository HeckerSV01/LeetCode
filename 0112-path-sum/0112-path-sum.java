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
    boolean ans=false;
    public void helper(TreeNode root,int sum,int num)
    {
        if(root==null)
        {
            return;
        }
        sum=sum+root.val;
        if(root.left==null&&root.right==null)
        {
            if(sum==num)
            {
                ans=true;
            }
            return;
        }
        helper(root.left,sum,num);
        helper(root.right,sum,num);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root,0,targetSum);
        return ans;
    }
}