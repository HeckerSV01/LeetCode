class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int deg[]=new int[n];
        Integer idx[]=new Integer[n];
        for(int i=0;i<n;i++)
        {
            idx[i]=i;
        }
        for(int i=0;i<roads.length;i++)
        {
            deg[roads[i][0]]++;
            deg[roads[i][1]]++;
        }
        Arrays.sort(idx,(a,b)->deg[b]-deg[a]);
        long a[]=new long[n];
        int k=n;
        for(int i=0;i<n;i++)
        {
            a[idx[i]]=k;
            k--;
        }
        long res=0;
        for(int i=0;i<roads.length;i++)
        {
            res=res+a[roads[i][0]]+a[roads[i][1]];
        }
        return res;
    }
}