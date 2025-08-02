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
    public TreeNode build(int pre[],int in[],HashMap<Integer,Integer> map,int inst,int inend,int prest,int preend)
    {
        if(inst>inend||prest>preend)
        {
            return null;
        }
        TreeNode root=new TreeNode(pre[prest]);
        int rootidx=map.get(pre[prest]);
        int leftsize=rootidx-inst;
        root.left=build(pre,in,map,inst,rootidx-1,prest+1,prest+leftsize);
        root.right=build(pre,in,map,rootidx+1,inend,prest+leftsize+1,preend);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,map,0,inorder.length-1,0,preorder.length-1);
    }
}