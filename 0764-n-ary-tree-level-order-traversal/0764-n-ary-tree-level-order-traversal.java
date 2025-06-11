/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null)
        {
            return list;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                Node n=q.remove();
                l.add(n.val);
                for(Node k:n.children)
                {
                    q.add(k);
                }
            }
            list.add(l);
        }
        return list;
    }
}