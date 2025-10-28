class Solution {
    public void dfs(int st,HashSet<Integer> set,List<Integer> res,HashMap<Integer,List<Integer>> map)
    {
        set.add(st);
        res.add(st);
        for(int k:map.get(st))
        {
            if(!set.contains(k))
            {
                dfs(k,set,res,map);
            }
        }
    }
    public int[] restoreArray(int[][] adj) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int k[]:adj)
        {
            if(!map.containsKey(k[0]))
            {
                map.put(k[0],new ArrayList<>());
            }
            map.get(k[0]).add(k[1]);
            if(!map.containsKey(k[1]))
            {
                map.put(k[1],new ArrayList<>());
            }
            map.get(k[1]).add(k[0]);
        }
        int st=-1;
        for(int k:map.keySet())
        {
            if(map.get(k).size()==1)
            {
                st=k;
                break;
            }
        }
        HashSet<Integer> visited=new HashSet<>();
        List<Integer> res=new ArrayList<>();
        dfs(st,visited,res,map);
        int a[]=new int[res.size()];
        int i=0;
        for(int k:res)
        {
            a[i++]=k;
        }
        return a;
    }
}