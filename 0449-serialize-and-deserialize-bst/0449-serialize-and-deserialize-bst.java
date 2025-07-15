/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
static TreeNode roott;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.roott=root;
        String st="";
        return st;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return roott;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;