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
    public TreeNode traverse(TreeNode root,int val)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==val)
        {
            return del(root);
        }
        TreeNode temp=root;
        while(root!=null)
        {
            if(root.val>val)
            {
                if(root.left!=null&&root.left.val==val)
                {
                    root.left=del(root.left);
                    break;
                }
                else
                {
                    root=root.left;
                }
            }
            else
            {
                if(root.right!=null&&root.right.val==val)
                {
                    root.right=del(root.right);
                    break;
                }
                else
                {
                    root=root.right;
                }
            }
        }
        return temp;
    }
    public TreeNode del(TreeNode root)
    {
        if(root.left==null&&root.right==null)
        {
            return null;
        }
        else if(root.left!=null&&root.right==null)
        {
            return root.left;
        }
        else if(root.left==null&&root.right!=null)
        {
            return root.right;
        }
        else
        {
            TreeNode pred=findrofl(root.left);
            root.val=pred.val; 
            root.left=deleteNode(root.left,pred.val); 
            return root;
        }
    }
    public  TreeNode findrofl(TreeNode root)
    {
        if(root.right==null)
        {
            return root;
        }
        return findrofl(root.right);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return traverse(root,key);
    }
}