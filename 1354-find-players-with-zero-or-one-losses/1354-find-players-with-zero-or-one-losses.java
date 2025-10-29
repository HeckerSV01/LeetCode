class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> lose=new HashMap<>();
        for(int k[]:matches)
        {
            lose.putIfAbsent(k[0],0);
            lose.put(k[1],lose.getOrDefault(k[1],0)+1);
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp1=new ArrayList<>();
        List<Integer> temp2=new ArrayList<>();
        for(int k:lose.keySet())
        {
            if(lose.get(k)==0)
            {
                temp1.add(k);
            }
            if(lose.get(k)==1)
            {
                temp2.add(k);
            }
        }
        Collections.sort(temp1);
        Collections.sort(temp2);
        res.add(temp1);
        res.add(temp2);
        return res;
    }
}