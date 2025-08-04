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
    List<Integer> list=new ArrayList<>();
    public void dfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int left=0;
        int right=list.size()-1;
        while(left<right)
        {
            if(list.get(left)+list.get(right)>k)
            {
                right--;
            }
            else if(list.get(left)+list.get(right)<k)
            {
                left++;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}