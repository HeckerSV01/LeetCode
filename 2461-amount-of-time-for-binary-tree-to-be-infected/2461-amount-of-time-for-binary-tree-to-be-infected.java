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
    public TreeNode marker(TreeNode root,HashMap<TreeNode,TreeNode> map,int start)
    {
        TreeNode t=new TreeNode(-1);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node=q.remove();
            if(node.val==start)
            {
                t=node;
            }
            if(node.left!=null)
            {
                q.add(node.left);
                map.put(node.left,node);
            }
            if(node.right!=null)
            {
                q.add(node.right);
                map.put(node.right,node);
            }
        }
        return t;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        TreeNode st=marker(root,map,start);
        Queue<TreeNode> q=new LinkedList<>();
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        q.add(st);
        visited.put(st,true);
        int dist=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            dist++;
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.remove();
                if(node.left!=null&&visited.get(node.left)==null)
                {
                    q.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null&&visited.get(node.right)==null)
                {
                    q.add(node.right);
                    visited.put(node.right,true);
                }
                if(map.get(node)!=null&&visited.get(map.get(node))==null)
                {
                    q.add(map.get(node));
                    visited.put(map.get(node),true);
                }
            }
        }
        return dist-1;
    }
}