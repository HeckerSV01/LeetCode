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
    int res=0;
    public int recur(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left=recur(root.left);
        int right=recur(root.right);
        if(left==-1||right==-1) {
            res++;
            return 1;
        }
        if(left==1||right==1){
            return 0;
        }
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        int k=recur(root);
        if(k==-1){
            return res+1;
        } else {
            return res;
        }
    }
}