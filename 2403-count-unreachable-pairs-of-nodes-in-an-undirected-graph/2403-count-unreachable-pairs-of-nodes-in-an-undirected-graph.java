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
    public long countPairs(int n, int[][] edges) {
        disjointSet ds=new disjointSet(n);
        for(int i=0;i<edges.length;i++)
        {
            ds.unionbysize(edges[i][0],edges[i][1]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int p=ds.find(i);
            map.put(p,map.getOrDefault(p,0)+1);
        }
        long total=(long)n*(long)(n-1)/2;
        long reachable=0;
        for(int k:map.values())
        {
            reachable=(long)reachable+(long)k*(long)(k-1)/2;
        }
        return total-reachable;
    }
}