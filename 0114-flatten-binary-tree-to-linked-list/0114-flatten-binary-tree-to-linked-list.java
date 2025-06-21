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
    public void preorder(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
        {
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }
    public ArrayList<Integer> help(TreeNode root)
    {
        ArrayList<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;
    }
    public void flatten(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        list=help(root);
        TreeNode res=root;
        for(int i=1;i<list.size();i++)
        {
            res.right=new TreeNode(list.get(i));
            res.left=null;
            res=res.right;
        }
    }
}