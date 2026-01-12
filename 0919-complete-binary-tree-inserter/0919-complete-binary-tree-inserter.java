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
    Queue<TreeNode> q;
    public CBTInserter(TreeNode root) {
        this.root=root;
        q=new LinkedList<>();
        Queue<TreeNode> temp=new LinkedList<>();
        temp.add(root);
        while(!temp.isEmpty()){
            TreeNode t=temp.remove();
            if(t.left==null||t.right==null){
                q.add(t);
            }
            if(t.left!=null){
                temp.add(t.left);
            }
            if(t.right!=null){
                temp.add(t.right);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode node=new TreeNode(val);
        TreeNode parent=q.peek();
        if(parent.left==null){
            parent.left=node;
        } else {
            parent.right=node;
            q.remove();
        }
        q.add(node);
        return parent.val;
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