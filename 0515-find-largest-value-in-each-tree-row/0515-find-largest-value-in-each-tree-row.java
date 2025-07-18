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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
        {
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.remove();
                max=Math.max(max,n.val);
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                    q.add(n.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}