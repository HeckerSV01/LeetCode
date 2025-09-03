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
    public int makeConnected(int n, int[][] connections) {
        disjointSet ds=new disjointSet(n);
        int edges=0;
        for(int i=0;i<connections.length;i++)
        {
            if(ds.find(connections[i][0])==ds.find(connections[i][1]))
            {
                edges++;
            }
            else
            {
                ds.unionbysize(connections[i][0],connections[i][1]);
            }
        }
        int compo=0;
        for(int i=0;i<n;i++)
        {
            if(ds.find(i)==i)
            {
                compo++;
            }
        }
        if(edges>=compo-1)
        {
            return compo-1;
        }
        return -1;
    }
}