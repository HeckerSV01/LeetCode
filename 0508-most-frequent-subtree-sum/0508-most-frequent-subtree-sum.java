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
    HashMap<Integer,Integer> map=new HashMap<>();
    public int sum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftsum=sum(root.left);
        int rightsum=sum(root.right);
        int k=leftsum+rightsum+root.val;
        map.put(k,map.getOrDefault(k,0)+1);
        return k;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        ArrayList<Integer> l=new ArrayList<>();
        int max=-1;
        for(int k:map.values())
        {
            if(k>max)
            {
                max=k;
            }
        }   
        for(int k:map.keySet())
        {
            if(map.get(k)==max)
            {
                l.add(k);
            }
        }
        int res[]=new int[l.size()];
        for(int i=0;i<l.size();i++)
        {
            res[i]=l.get(i);
        }
        return res;
    }
}