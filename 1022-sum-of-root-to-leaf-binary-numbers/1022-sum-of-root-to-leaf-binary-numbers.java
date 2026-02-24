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
    List<String> list = new ArrayList<>();

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        if (root.left != null) {
            dfs(root.left, sb);
        }
        if (root.right != null) {
            dfs(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        int sum = 0;
        for (String s : list) {
            sum = sum + Integer.parseInt(s, 2);
        }
        return sum;
    }
}