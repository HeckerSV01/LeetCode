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
    public int removeStones(int[][] stones) {
        disjointSet ds=new disjointSet(stones.length);
        for(int i=0;i<stones.length-1;i++)
        {
            int r=stones[i][0];
            int c=stones[i][1];
            for(int j=i+1;j<stones.length;j++)
            {
                if(stones[j][0]==r||stones[j][1]==c)
                {
                    ds.unionbysize(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<stones.length;i++)
        {
            if(ds.parent.get(i)==i)
            {
                count++;
            }
        }
        return stones.length-count;
    }
}