/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node node,Node newnode,Node vis[])
    {
        vis[newnode.val]=newnode;
        for(Node n:node.neighbors)
        {
            if(vis[n.val]==null)
            {
                Node copy=new Node(n.val);
                newnode.neighbors.add(copy);
                dfs(n,copy,vis);
            }
            else
            {
                newnode.neighbors.add(vis[n.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null)
        {
            return null;
        }
        Node vis[]=new Node[101];
        Arrays.fill(vis,null);
        Node newnode=new Node(node.val);
        dfs(node,newnode,vis);
        return newnode;
    }
}