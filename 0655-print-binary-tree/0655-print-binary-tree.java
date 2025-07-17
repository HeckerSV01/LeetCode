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
    List<List<String>> res=new ArrayList<>();
    public void init(int m,int n)
    {
        for(int i=0;i<m;i++)
        {
            List<String> l=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                l.add("");
            }
            res.add(l);
        }
    }
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public void fill(TreeNode root,int row,int l,int r)
    {
        if(root==null)
        {
            return;
        }
        int mid=(l+r)/2;
        res.get(row).set(mid,Integer.toString(root.val));
        fill(root.left,row+1,l,mid-1);
        fill(root.right,row+1,mid+1,r);
    }
    public List<List<String>> printTree(TreeNode root) {
        int h=height(root);
        int m=h;
        int n=(int)(Math.pow(2,h)-1);
        init(m,n);
        fill(root,0,0,n-1);
        return res;
    }
}