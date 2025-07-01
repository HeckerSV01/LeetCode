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
    public TreeNode helper(int arr[])
    {
        if(arr.length==0)
        {
            return null;
        }
        TreeNode root=new TreeNode(arr[0]);
        int idx=arr.length;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[0])
            {
                idx=i;
                break;
            }
        }
        int leftarr[]=Arrays.copyOfRange(arr,1,idx);
        int rightarr[]=Arrays.copyOfRange(arr,idx,arr.length);
        root.left=helper(leftarr);
        root.right=helper(rightarr);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder);
    }
}