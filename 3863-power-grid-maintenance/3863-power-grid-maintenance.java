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
    public int getmin(TreeSet<Integer> set,disjointSet ds,int n)
    {
        for(int k:set)
        {
            if(ds.find(k)==ds.find(n))
            {
                return k;
            }
        }
        return -1;
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        boolean status[]=new boolean[c+1];
        Arrays.fill(status,true);
        disjointSet ds=new disjointSet(c+1);
        for(int k[]:connections)
        {
            ds.unionbysize(k[0],k[1]);
        }
        HashMap<Integer,TreeSet<Integer>> map=new HashMap<>();
        for(int i=1;i<=c;i++)
        {
            int par=ds.find(i);
            if(!map.containsKey(par))
            {
                map.put(par,new TreeSet<>());
            }
            map.get(par).add(i);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int k[]:queries)
        {
            if(k[0]==1)
            {
                if(status[k[1]])
                {
                    list.add(k[1]);
                }
                else
                {
                    int par=ds.find(k[1]);
                    TreeSet<Integer> set=map.get(par);
                    if(set==null||set.isEmpty())
                    {
                        list.add(-1);
                    }
                    else
                    {
                        list.add(set.first());
                    }
                }
            }
            else 
            {
                status[k[1]]=false;
                int par=ds.find(k[1]);
                map.get(par).remove(k[1]);
            }
        }
        int res[]=new int[list.size()];
        int i=0;
        for(int k:list)
        {
            res[i++]=k;
        }
        return res;
    }
}