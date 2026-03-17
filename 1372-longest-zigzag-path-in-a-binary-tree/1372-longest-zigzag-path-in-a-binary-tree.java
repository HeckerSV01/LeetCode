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
    int max=0;
    private int solve(TreeNode root, boolean isright,HashMap<TreeNode,int[]> dp) {
        if(root==null){
            return 0;
        }
        if ((isright&&root.right == null)||(!isright&&root.left==null)) {
            return 0;
        }
        if(!dp.containsKey(root)){
            dp.put(root,new int[]{-1,-1});
        }
        int dir=(isright)?1:0;
        if(dp.get(root)[dir]!=-1){
            return dp.get(root)[dir];
        }
        int cont=0;
        if(isright){
            cont=1+solve(root.right,!isright,dp);
        }else{
            cont=1+solve(root.left,!isright,dp);
        }
        int restartleft=0;
        int restartright=0;
        if(root.left!=null){
            restartleft=solve(root.left,false,dp);
        }
        if(root.right!=null){
            restartright=solve(root.right,true,dp);
        }
        max=Math.max(cont,max);
        dp.get(root)[dir]=cont;
        return cont;
    }

    public int longestZigZag(TreeNode root) {
        HashMap<TreeNode,int[]> dp=new HashMap<>();
        solve(root,true,dp);
        solve(root,false,dp);
        return max;
    }
}