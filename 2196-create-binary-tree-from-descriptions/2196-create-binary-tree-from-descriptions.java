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
    public TreeNode createtree(int k,HashMap<Integer,int[]> map)
    {

        TreeNode root=new TreeNode(k);
        if(map.containsKey(k))
        {
            int a[]=map.get(k);
            if(a[0]!=-1)
            {
                root.left=createtree(a[0],map);
            }
            if(a[1]!=-1)
            {
                root.right=createtree(a[1],map);
            }
        }
        return root;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,int[]> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int a[]:descriptions)
        {
            int p=a[0];
            int c=a[1];
            boolean isleft=a[2]==1;
            if(!map.containsKey(p))
            {
                map.put(p,new int[]{-1,-1});
            }
            set.add(c);
            if(isleft)
            {
                map.get(p)[0]=c;
            }
            else
            {
                map.get(p)[1]=c;
            }
        }
        int rootvalue=0;
        for(int value:map.keySet())
        {
            if(!set.contains(value))
            {
                rootvalue=value;
            }
        }
        return createtree(rootvalue,map);
    }
}