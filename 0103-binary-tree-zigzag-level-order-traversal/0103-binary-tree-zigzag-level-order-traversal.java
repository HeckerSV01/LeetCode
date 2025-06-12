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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
        {
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean check=true;
        while(!q.isEmpty())
        {
            List<Integer> l=new ArrayList<>();
            int size=q.size();
            int i=0;
            for(i=0;i<size;i++)
            {
                TreeNode n=q.remove();
                l.add(n.val);
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                    q.add(n.right);
                }
            }
            if(check==false)
            {
                Collections.reverse(l);
            }
            list.add(l);
            check=!check;
        }
        return list;
    }
}