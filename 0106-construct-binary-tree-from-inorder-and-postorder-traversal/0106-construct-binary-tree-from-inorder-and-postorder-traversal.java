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
    public TreeNode build(int post[],int in[],HashMap<Integer,Integer> map,int inst,int inend,int postst,int postend)
    {
        if(inst>inend||postst>postend)
        {
            return null;
        }
        TreeNode root=new TreeNode(post[postend]);
        int rootidx=map.get(post[postend]);
        int leftsize=rootidx-inst;
        root.left=build(post,in,map,inst,rootidx-1,postst,postst+leftsize-1);
        root.right=build(post,in,map,rootidx+1,inend,postst+leftsize,postend-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return build(postorder,inorder,map,0,inorder.length-1,0,postorder.length-1);
    }
}