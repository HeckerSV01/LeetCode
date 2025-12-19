class disjointSet{
    public int parent[];
    public int size[];
    public disjointSet(int n)
    {
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int node)
    {
        if(node==parent[node])
        {
            return node;
        }
        int ultparent=find(parent[node]);
        parent[node]=ultparent;
        return parent[node];
    }
    public void unionbysize(int u,int v)
    {
        int ultofu=find(u);
        int ultofv=find(v);
        if(ultofu==ultofv)
        {
            return;
        }
        if(size[ultofu]<size[ultofv])
        {
            parent[ultofu]=ultofv;
            size[ultofv]=size[ultofv]+size[ultofu];
        }
        else
        {
            parent[ultofv]=ultofu;
            size[ultofu]=size[ultofu]+size[ultofv];
        }
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings,(x,y)->x[2]-y[2]);
        disjointSet ds=new disjointSet(n);
        ds.unionbysize(0,firstPerson);
        List<Integer> res=new ArrayList<>();
        int i=0;
        while(i<meetings.length)
        {
            List<int[]> same=new ArrayList<>();
            int time=meetings[i][2];
            while(i<meetings.length&&meetings[i][2]==time)
            {
                same.add(meetings[i]);
                i++;
            }
            for(int j=0;j<same.size();j++)
            {
                ds.unionbysize(same.get(j)[0],same.get(j)[1]);
            }
            for(int a[]:same)
            {
                int u=a[0];
                int v=a[1];
                if(ds.find(u)!=ds.find(0))
                {
                    ds.parent[u]=u;
                    ds.size[u]=1;
                }
                if(ds.find(v)!=ds.find(0))
                {
                    ds.parent[v]=v;
                    ds.size[v]=1;
                }
            }
        }
        for(i=0;i<n;i++)
        {
            if(ds.find(i)==ds.find(0))
            {
                res.add(i);
            }
        }
        return res;
    }
}