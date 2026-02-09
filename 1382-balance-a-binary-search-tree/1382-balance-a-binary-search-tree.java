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
    int i=0;
    int arr[];
    public int nodes(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return nodes(root.left)+nodes(root.right)+1;
    }
    public void treetoarr(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        treetoarr(root.left);
        arr[i]=root.val;
        i++;
        treetoarr(root.right);
    }
    public TreeNode arrtotree(int a[],int st,int en)
    {
        if(st>en)
        {
            return null;
        }
        int mid=st+(en-st)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=arrtotree(a,st,mid-1);
        root.right=arrtotree(a,mid+1,en);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        int size=nodes(root);
        arr=new int[size];
        treetoarr(root);
        return arrtotree(arr,0,arr.length-1);
    }
}