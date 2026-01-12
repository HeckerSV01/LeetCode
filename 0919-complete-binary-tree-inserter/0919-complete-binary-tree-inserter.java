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
class CBTInserter {
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root=root;
    }
    
    public int insert(int val) {
        TreeNode node=new TreeNode(val);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t=q.remove();
            if(t.left!=null&&t.right!=null){
                q.add(t.left);
                q.add(t.right);
            } else {
                if(t.left==null){
                    t.left=node;
                } else if(t.right==null){
                    t.right=node;
                }
                return t.val;
            }
        }
        return -1;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */