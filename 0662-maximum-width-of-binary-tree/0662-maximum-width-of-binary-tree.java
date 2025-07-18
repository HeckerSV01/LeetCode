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
    class pair
    {
        TreeNode node;
        int idx;
        pair(TreeNode node,int idx)
        {
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        int width=0;
        q.add(new pair(root,1));
        while(!q.isEmpty())
        {
            int len=q.size();
            int first=q.peek().idx;
            int idx=0;
            for(int i=0;i<len;i++)
            {
                pair p=q.remove();
                TreeNode node=p.node;
                idx=p.idx;
                if(node.left!=null)
                {
                    q.add(new pair(node.left,2*idx));
                }
                if(node.right!=null)
                {
                    q.add(new pair(node.right,2*idx+1));
                }
            }
            width=Math.max(width,idx-first+1);
        }
        return width;
    }
}