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
    public int[] max(int arr[])
    {
        int max=arr[0];
        int idx=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                idx=i;
            }
        }
        int a[]={max,idx};
        return a;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return null;
        }
        int arr[]=new int[2];
        arr=max(nums);
        int val=arr[0];
        int idx=arr[1];
        TreeNode root=new TreeNode(arr[0]);
        int lsub[]=Arrays.copyOfRange(nums,0,idx);
        int rsub[]=Arrays.copyOfRange(nums,idx+1,nums.length);
        root.left=constructMaximumBinaryTree(lsub);
        root.right=constructMaximumBinaryTree(rsub);
        return root;
    }
}