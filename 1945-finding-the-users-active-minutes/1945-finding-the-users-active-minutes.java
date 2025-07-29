class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<logs.length;i++)
        {
            if(!map.containsKey(logs[i][0]))
            {
                map.put(logs[i][0],new HashSet<>());
            }
            map.get(logs[i][0]).add(logs[i][1]);
        }
        int res[]=new int[k];
        for(HashSet<Integer> set:map.values())
        {
            res[set.size()-1]++;
        }
        return res;
    }
}