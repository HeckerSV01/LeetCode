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
    public TreeNode build(int a[])
    {
        if(a.length==0)
        {
            return null;
        }
        int val=a[a.length/2];
        TreeNode root=new TreeNode(val);
        int left[]=Arrays.copyOfRange(a,0,a.length/2);
        int right[]=Arrays.copyOfRange(a,a.length/2+1,a.length);
        root.left=build(left);
        root.right=build(right);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums);
    }
}