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
    private void dfs(TreeNode root,StringBuilder sb,List<String> list){
        if(root==null){
            return;
        }
        
        sb.append((char)('a'+root.val));
        if(root.left==null&&root.right==null){
            StringBuilder temp=new StringBuilder(sb);
            list.add(temp.reverse().toString());
        }
        dfs(root.left,sb,list);
        dfs(root.right,sb,list);
        
        sb.deleteCharAt(sb.length()-1);
    }
    public String smallestFromLeaf(TreeNode root) {
        List<String> list=new ArrayList<>();
        dfs(root,new StringBuilder(),list);
        Collections.sort(list);
        return list.get(0);
    }
}