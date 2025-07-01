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
class FindElements {
    HashSet<Integer> set;
    TreeNode cbt;
    public FindElements(TreeNode root) {
        set=new HashSet<>();
        cbt=root;
        if(cbt!=null)
        {
            cbt.val=0;
            recover(cbt);
        }
    }
    public void recover(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        set.add(root.val);
        if(root.left!=null)
        {
            root.left.val=root.val*2+1;
        }
        if(root.right!=null)
        {
            root.right.val=2*root.val+2;
        }
        recover(root.left);
        recover(root.right);
    }
    public boolean find(int target) {
        if(set.contains(target))
        {
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */