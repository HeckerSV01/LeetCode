class pair{
    int i;
    int j;
    int wt;
    public pair(int i,int j,int wt)
    {
        this.i=i;
        this.j=j;
        this.wt=wt;
    }
}
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
    public int minCostConnectPoints(int[][] points) {
        List<pair> edges=new ArrayList<>();
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int dis=Math.abs(points[j][1]-points[i][1])+Math.abs(points[j][0]-points[i][0]);
                edges.add(new pair(i,j,dis));
            }
        }
        int res=0;
        int count=0;
        edges.sort((a,b)->a.wt-b.wt);
        disjointSet ds=new disjointSet(points.length);
        for(pair p:edges)
        {
            if(ds.find(p.i)!=ds.find(p.j))
            {
                ds.unionbysize(p.i,p.j);
                res=res+p.wt;
                count++;
            }
            if(count==points.length-1)
            {
                break;
            }
        }
        return res;
    }
}