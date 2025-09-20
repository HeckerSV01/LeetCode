class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        int max=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int count=0;
                if(adj.get(i).contains(j))
                {
                    count=adj.get(i).size()+adj.get(j).size()-1;
                }
                else
                {
                    count=adj.get(i).size()+adj.get(j).size();
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
}