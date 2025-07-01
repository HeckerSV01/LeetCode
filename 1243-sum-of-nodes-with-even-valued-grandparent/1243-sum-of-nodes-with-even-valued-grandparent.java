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
    public int helper(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int sum=0;
        int node=root.val;
        if(node%2==0)
        {
            if(root.left!=null)
            {
                if(root.left.left!=null)
                {
                    sum=sum+root.left.left.val;
                }
                if(root.left.right!=null)
                {
                    sum=sum+root.left.right.val;
                }
            }
            if(root.right!=null)
            {
                if(root.right.left!=null)
                {
                    sum=sum+root.right.left.val;
                }
                if(root.right.right!=null)
                {
                    sum=sum+root.right.right.val;
                }
            }
        }
        int lsum=helper(root.left);
        int rsum=helper(root.right);
        return lsum+rsum+sum;
    }
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root);
    }
}