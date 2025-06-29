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
    public List<Integer> traverse(TreeNode root)
    {
        List<Integer> list=new ArrayList<>();
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
            for(int j=0;j<l.size();j++)
            {
                list.add(l.get(j));
            }
            check=!check;
        }
        return list;
    }
    public TreeNode buildtree(List<Integer> list,int i)
    {
        if(i>=list.size())
        {
            return null;
        }
        TreeNode root=new TreeNode(list.get(i));
        root.left=buildtree(list,2*i+1);
        root.right=buildtree(list,2*i+2);
        return root;
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        List<Integer> list=traverse(root);
        TreeNode res=buildtree(list,0);
        return res;
    }
}