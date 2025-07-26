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
    public TreeNode recur(TreeNode root,HashSet<Integer> set)
    {
        if(root==null||set.contains(root.val))
        {
            return root;
        }
        TreeNode left=recur(root.left,set);
        TreeNode right=recur(root.right,set);
        if(left==null)
        {
            return right;
        }
        else if(right==null)
        {
            return left;
        }
        else
        {
            return root;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<List<Integer>> list=bfs(root);
        List<Integer> l=list.get(list.size()-1);
        HashSet<Integer> set=new HashSet<>();
        for(int k:l)
        {
            set.add(k);
        }
        return recur(root,set);
    }
}