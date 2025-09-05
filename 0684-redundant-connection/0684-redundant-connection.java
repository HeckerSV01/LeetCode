class disjointSet{
    public List<Integer> parent=new ArrayList<>();
    public List<Integer> size=new ArrayList<>();
    public disjointSet(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int find(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }
        int ultparent=find(parent.get(node));
        parent.set(node,ultparent);
        return parent.get(node);
    }
    public void unionbysize(int u,int v)
    {
        int ultofu=find(u);
        int ultofv=find(v);
        if(ultofu==ultofv)
        {
            return;
        }
        if(size.get(ultofu)<size.get(ultofv))
        {
            parent.set(ultofu,ultofv);
            size.set(ultofv,size.get(ultofv)+size.get(ultofu));
        }
        else
        {
            parent.set(ultofv,ultofu);
            size.set(ultofu,size.get(ultofu)+size.get(ultofv));
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int res[]=new int[2];
        disjointSet ds=new disjointSet(edges.length+1);
        for(int i=0;i<edges.length;i++)
        {
            if(ds.find(edges[i][0])==ds.find(edges[i][1]))
            {
                res[0]=edges[i][0];
                res[1]=edges[i][1];
            }
            else
            {
                ds.unionbysize(edges[i][0],edges[i][1]);
            }
        }
        return res;
    }
}