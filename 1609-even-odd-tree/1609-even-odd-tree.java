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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean even = true;
        while (!q.isEmpty()) {
            int size = q.size();
            int prev = 0;
            if (even) {
                prev = Integer.MIN_VALUE;
            } else {
                prev = Integer.MAX_VALUE;
            }
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if (even) {
                    if (cur.val % 2 == 0 || cur.val <= prev) {
                        return false;
                    }
                } else {
                    if (cur.val % 2 != 0 || cur.val >= prev) {
                        return false;
                    }
                }
                prev = cur.val;

                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            even = !even;
        }
        return true;
    }
}