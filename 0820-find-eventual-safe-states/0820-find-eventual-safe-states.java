class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjrev=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            adjrev.add(new ArrayList<>());
        }
        int inc[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            for(int k:graph[i])
            {
                adjrev.get(k).add(i);
                inc[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> safe=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(inc[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int node=q.remove();
            safe.add(node);
            for(int k:adjrev.get(node))
            {
                inc[k]--;
                if(inc[k]==0)
                {
                    q.add(k);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}