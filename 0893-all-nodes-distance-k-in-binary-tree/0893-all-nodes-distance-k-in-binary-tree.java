/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void marker(TreeNode root,HashMap<TreeNode,TreeNode> map)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node=q.remove();
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
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        marker(root,map);
        Queue<TreeNode> q=new LinkedList<>();
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        q.add(target);
        visited.put(target,true);
        int dist=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            if(dist==k)
            {
                break;
            }
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
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode t=q.remove();
            res.add(t.val);
        }
        return res;
    }
}