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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        List<Integer> list=new ArrayList<>();
        s.push(root);
        if(root==null)
        {
            return list;
        }
        while(!s.isEmpty())
        {
            TreeNode n=s.pop();
            list.add(n.val);
            if(n.right!=null)
            {
                s.push(n.right);
            }
            if(n.left!=null)
            {
                s.push(n.left);
            }
        }
        return list;
    }
}