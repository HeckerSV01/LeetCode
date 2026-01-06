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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int maxlevel=1;
        int level=1;
        int max=Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty())
        {
            int sum=0;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.remove();
                sum=sum+n.val;
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                    q.add(n.right);
                }
            }
            if(sum>max)
            {
                max=sum;
                maxlevel=level;
            }
            level++;
        }
        return maxlevel;
    }
}