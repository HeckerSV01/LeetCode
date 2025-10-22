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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        disjointSet ds=new disjointSet(n);
        for(int i=1;i<n;i++)
        {
            if(nums[i]-nums[i-1]<=maxDiff)
            {
                ds.unionbysize(i-1,i);
            }
        }
        boolean res[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            if(ds.find(queries[i][0])==ds.find(queries[i][1]))
            {
                res[i]=true;
            }
        }
        return res;
    }
}