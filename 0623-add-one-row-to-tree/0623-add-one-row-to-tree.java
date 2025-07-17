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
    public TreeNode dfs(TreeNode root,int val,int d,int i)
    {
        if(root==null)
        {
            return null;
        }
        if(i==d-1)
        {
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=left;
            root.right.right=right;
        }
        root.left=dfs(root.left,val,d,i+1);
        root.right=dfs(root.right,val,d,i+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        return dfs(root,val,depth,1);
    }
}