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
    public int largestIsland(int[][] grid) {
        int m=grid.length;
        disjointSet ds=new disjointSet(m*m);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                {
                    continue;
                }
                int row=i+1;
                int col=j;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    int nodenumber=i*m+j;
                    int adjnodenumber=row*m+col;
                    ds.unionbysize(nodenumber,adjnodenumber);
                }
                row=i-1;
                col=j;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    int nodenumber=i*m+j;
                    int adjnodenumber=row*m+col;
                    ds.unionbysize(nodenumber,adjnodenumber);
                }
                row=i;
                col=j+1;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    int nodenumber=i*m+j;
                    int adjnodenumber=row*m+col;
                    ds.unionbysize(nodenumber,adjnodenumber);
                }
                row=i;
                col=j-1;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    int nodenumber=i*m+j;
                    int adjnodenumber=row*m+col;
                    ds.unionbysize(nodenumber,adjnodenumber);
                }
            }
        }
        int res=-1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    continue;
                }
                HashSet<Integer> set=new HashSet<>();
                int row=i+1;
                int col=j;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    set.add(ds.find(row*m+col));
                }
                row=i-1;
                col=j;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    set.add(ds.find(row*m+col));
                }
                row=i;
                col=j+1;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    set.add(ds.find(row*m+col));
                }
                row=i;
                col=j-1;
                if(row>=0&&row<m&&col>=0&&col<m&&grid[row][col]==1)
                {
                    set.add(ds.find(row*m+col));
                }
                int sum=0;
                for(int k:set)
                {
                    sum=sum+ds.size.get(k);
                }
                res=Math.max(res,sum+1);
            }
        }
        for(int i=0;i<m*m;i++)
        {
            res=Math.max(res,ds.size.get(ds.find(i)));
        }
        return res;
    }
}