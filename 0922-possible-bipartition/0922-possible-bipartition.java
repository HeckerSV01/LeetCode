class Solution {
    public boolean check(List<List<Integer>> adj,int col[],int node)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        col[node]=1;
        while(!q.isEmpty())
        {
            int curr=q.remove();
            for(int k:adj.get(curr))
            {
                if(col[k]==0)
                {
                if(col[curr]==1)
                {
                    col[k]=2;
                }
                else 
                {
                    col[k]=1;
                }
                q.add(k);
                }
                else if(col[k]==col[curr])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj=new ArrayList<>();
        int col[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++)
        {
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        for(int i=1;i<adj.size();i++)
        {
            if(col[i]==0)
            {
                if(check(adj,col,i)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
}