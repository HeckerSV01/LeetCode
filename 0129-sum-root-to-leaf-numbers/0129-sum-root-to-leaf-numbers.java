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
    ArrayList<Integer> list=new ArrayList<>();
    public void dfs(TreeNode root,int num)
    {
        if(root==null)
        {
            return;
        }
        num=num*10+root.val;
        if(root.left==null&&root.right==null)
        {
            list.add(num);
            num=0;
            return;
        }
        dfs(root.left,num);
        dfs(root.right,num);
    }
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        int res=0;
        for(int i=0;i<list.size();i++)
        {
            res=res+list.get(i);
        }
        return res;
    }
}