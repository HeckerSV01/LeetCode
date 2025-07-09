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
    int idx=0;
    public TreeNode build(String s,int depth)
    {
        int dash=0;
        while(dash+idx<s.length()&&s.charAt(dash+idx)=='-')
        {
            dash++;
        }
        if(dash!=depth)
        {
            return null;
        }
        idx=idx+dash;
        int val=0;
        while(idx<s.length()&&Character.isDigit(s.charAt(idx)))
        {
            val=val*10+Integer.parseInt(String.valueOf(s.charAt(idx)));
            idx++;
        }
        TreeNode root=new TreeNode(val);
        root.left=build(s,depth+1);
        root.right=build(s,depth+1);
        return root;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal,0);
    }
}