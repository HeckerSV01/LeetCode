class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,HashSet<Integer>> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        int res[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            if(map2.containsKey(queries[i][0]))
            {
                map1.get(map2.get(queries[i][0])).remove(queries[i][0]);
                if(map1.get(map2.get(queries[i][0])).size()==0)
                {
                    map1.remove(map2.get(queries[i][0]));
                }
            }
                map2.put(queries[i][0],queries[i][1]);
                if(!map1.containsKey(queries[i][1]))
                {
                    map1.put(queries[i][1],new HashSet<>());
                }
                map1.get(queries[i][1]).add(queries[i][0]);
            res[i]=map1.size();
        }
        return res;
    }
}