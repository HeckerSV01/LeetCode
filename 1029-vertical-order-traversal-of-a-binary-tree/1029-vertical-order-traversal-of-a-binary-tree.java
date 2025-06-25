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
class values
{
    TreeNode node;
    int value;
    int row;
    int col;
    public values(TreeNode node,int row,int col)
    {
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<values> q=new LinkedList<>();
        q.add(new values(root,0,0));
        while(!q.isEmpty())
        {
            values curr=q.remove();
            TreeNode node=curr.node;
            int row=curr.row;
            int col=curr.col;
            if(!map.containsKey(col))
            {
                map.put(col,new TreeMap<>());
            }
            TreeMap<Integer,PriorityQueue<Integer>> m=map.get(col);
            if(!m.containsKey(row))
            {
                m.put(row,new PriorityQueue<>());
            }
            m.get(row).add(node.val);
            if(node.left!=null)
            {
                q.add(new values(node.left,row+1,col-1));
            }
            if(node.right!=null)
            {
                q.add(new values(node.right,row+1,col+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> m:map.values())
        {
            List<Integer> l=new ArrayList<>();
            for(PriorityQueue<Integer> queue:m.values())
            {
                while(!queue.isEmpty())
                {
                    l.add(queue.remove());
                }
            }
            res.add(l);
        }
        return res;
    }
}