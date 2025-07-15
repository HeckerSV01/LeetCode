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
    String st="";
    int idx=0;
    public void preorder(TreeNode root)
    {
        if(root==null)
        {
            st=st+"#,";
            return;
        }
        st=st+root.val+",";
        preorder(root.left);
        preorder(root.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preorder(root);
        return st;
    }
    public TreeNode build(String s[])
    {
        if(idx>=s.length||s[idx].equals("#"))
        {
            idx++;
            return null;
        }
        int value=Integer.parseInt(s[idx]);
        TreeNode root=new TreeNode(value);
        idx++;
        root.left=build(s);
        root.right=build(s);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String s[]=data.split(",");
        return build(s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));