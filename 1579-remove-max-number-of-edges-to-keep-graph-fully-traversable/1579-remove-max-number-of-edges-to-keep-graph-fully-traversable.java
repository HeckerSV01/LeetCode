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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        disjointSet ds1=new disjointSet(n);
        disjointSet ds2=new disjointSet(n);
        int count=0;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][0]==3)
            {
                if(ds1.find(edges[i][1]-1)==ds1.find(edges[i][2]-1))
                {
                    continue;
                }
                else
                {
                    ds1.unionbysize(edges[i][1]-1,edges[i][2]-1);
                    count++;
                }
                if(ds2.find(edges[i][1]-1)==ds2.find(edges[i][2]-1))
                {
                    continue;
                }
                else
                {
                    ds2.unionbysize(edges[i][1]-1,edges[i][2]-1);
                }
            }
        }
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][0]==1)
            {
                if(ds1.find(edges[i][1]-1)==ds1.find(edges[i][2]-1))
                {
                    continue;
                }
                else
                {
                    ds1.unionbysize(edges[i][1]-1,edges[i][2]-1);
                    count++;
                }
            }
        }
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][0]==2)
            {
                if(ds2.find(edges[i][1]-1)==ds2.find(edges[i][2]-1))
                {
                    continue;
                }
                else
                {
                    ds2.unionbysize(edges[i][1]-1,edges[i][2]-1);
                    count++;
                }
            }
        }
        boolean alicetravel=true;
        boolean bobtravel=true;
        int x=0;
        int y=0;
        for(int i=0;i<ds1.parent.size();i++)
        {
            if(ds1.parent.get(i)==i)
            {
                x++;
            }
            if(ds2.parent.get(i)==i)
            {
                y++;
            }
        }
        if(x>1)
        {
            alicetravel=false;
        }
        if(y>1)
        {
            bobtravel=false;
        }
        if(alicetravel&&bobtravel)
        {
            return edges.length-count;
        }
        else
        {
            return -1;
        }
    }
}