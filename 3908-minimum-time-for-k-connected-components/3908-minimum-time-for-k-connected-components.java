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
    public int components(int edges[][],int time,int n)
    {
        disjointSet ds=new disjointSet(n);
        for(int e[]:edges)
        {
            if(e[2]>time)
            {
                ds.unionbysize(e[0],e[1]);
            }
        }
        int c=0;
        for(int i=0;i<ds.parent.size();i++)
        {
            if(ds.parent.get(i)==i)
            {
                c++;
            }
        }
        return c;
    }
    public int minTime(int n, int[][] edges, int k) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        for(int i=0;i<edges.length;i++)
        {
            list.add(edges[i][2]);
        }
        Collections.sort(list);
        int st=0;
        int en=list.size()-1;
        int res=Integer.MAX_VALUE;
        while(st<=en)
        {
            int mid=(st+en)/2;
            int comp=components(edges,list.get(mid),n);
            if(comp>=k)
            {
                en=mid-1;
                res=list.get(mid);
            }
            else if(comp<k)
            {
                st=mid+1;
            }
        }
        return res;
    }
}