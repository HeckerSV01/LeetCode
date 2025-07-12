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
    List<List<Integer>> list=new ArrayList<>();
    public void traverse(TreeNode root,int sum,List<Integer> l,int num)
    {
        if(root==null)
        {
            return;
        }
        sum=sum+root.val;
        l.add(root.val);
        if(root.left==null&&root.right==null&&sum==num)
        {
            list.add(new ArrayList<>(l));
        }
            else
        {
            traverse(root.left,sum,l,num);
            traverse(root.right,sum,l,num);
        }
        l.remove(l.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root,0,new ArrayList<>(),targetSum);
        return list;
    }
}