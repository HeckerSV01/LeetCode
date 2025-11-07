class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int colsort[]=new int[k];
        int rowsort[]=new int[k];
        List<List<Integer>> adj1=new ArrayList<>();
        List<List<Integer>> adj2=new ArrayList<>();
        int inc1[]=new int[k+1];
        int inc2[]=new int[k+1];
        for(int i=0;i<=k;i++)
        {
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }
        for(int a[]:rowConditions)
        {
            adj1.get(a[0]).add(a[1]);
            inc1[a[1]]++;
        }
        for(int a[]:colConditions)
        {
            adj2.get(a[0]).add(a[1]);
            inc2[a[1]]++;
        }
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        for(int i=1;i<k+1;i++)
        {
            if(inc1[i]==0)
            {
                q1.add(i);
            }
        }
        int n=0;
        while(!q1.isEmpty())
        {
            int node=q1.remove();
            rowsort[n++]=node;
            for(int j:adj1.get(node))
            {
                inc1[j]--;
                if(inc1[j]==0)
                {
                    q1.add(j);
                }
            }
        }
        if(n<k)
        {
            return new int[0][0];
        }
        for(int i=1;i<k+1;i++)
        {
            if(inc2[i]==0)
            {
                q2.add(i);
            }
        }
        n=0;
        while(!q2.isEmpty())
        {
            int node=q2.remove();
            colsort[n++]=node;
            for(int j:adj2.get(node))
            {
                inc2[j]--;
                if(inc2[j]==0)
                {
                    q2.add(j);
                }
            }
        }
        if(n<k)
        {
            return new int[0][0];
        }
        int res[][]=new int[k][k];
        for(int i=0;i<k;i++)
        {
            int temp=rowsort[i];
            int col=0;
            for(int j=0;j<k;j++)
            {
                if(colsort[j]==temp)
                {
                    col=j;
                }
            }
            res[i][col]=temp;
        }
        return res;
    }
}