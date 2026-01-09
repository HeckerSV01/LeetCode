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
    private List<Integer> levelsum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            int sum = 0;
            for (int i = 0; i < s; i++) {
                TreeNode t = q.remove();
                sum = sum + t.val;
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            list.add(sum);
        }
        return list;
    }

    private void update(TreeNode root, List<Integer> list, int i) {
        if (root == null) {
            return;
        }
        int sibsum = 0;
        if (root.left != null) {
            sibsum = sibsum + root.left.val;
        }
        if (root.right != null) {
            sibsum = sibsum + root.right.val;
        }
        if (root.left != null)
            root.left.val = list.get(i + 1) - sibsum;

        if (root.right != null)
            root.right.val = list.get(i + 1) - sibsum;
        update(root.left, list, i + 1);
        update(root.right, list, i + 1);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> list = levelsum(root);
        root.val = 0;
        update(root, list, 0);
        return root;
    }
}