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
    long maxprod = 0;

    private int post(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = post(root.left);
        int right = post(root.right);
        return root.val = left + right + root.val;
    }

    private void traverse(TreeNode root, long total) {
        if (root == null) {
            return;
        }
        maxprod = Math.max(maxprod, (total - root.val) * root.val);
        traverse(root.left, total);
        traverse(root.right, total);
    }

    public int maxProduct(TreeNode root) {
        post(root);
        long total = root.val;
        traverse(root, total);
        return (int) (maxprod % 1_000_000_007);
    }
}