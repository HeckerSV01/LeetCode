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
    public List<List<Integer>> bfs(TreeNode root)
    {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
        {
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> l=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++)
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
            list.add(l);
        }
        return list;
    }
    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> list=bfs(root);
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            List<Integer> l=list.get(i);
            int max=Integer.MIN_VALUE;
            for(int j=0;j<l.size();j++)
            {
                if(l.get(j)>max)
                {
                    max=l.get(j);
                }
            }
            res.add(max);
        }
        return res;
    }
}