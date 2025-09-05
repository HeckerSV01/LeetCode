class Solution {
    public void dfs(int[][] graph,List<Integer> list,List<List<Integer>> res,int node)
    {
        if(node==graph.length-1)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int k:graph[node])
        {
            list.add(k);
            dfs(graph,list,res,k);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(0);
        dfs(graph,list,res,0);
        return res;
    }
}