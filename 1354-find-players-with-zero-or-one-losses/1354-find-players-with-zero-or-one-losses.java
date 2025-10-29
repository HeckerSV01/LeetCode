class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> lose=new HashMap<>();
        for(int k[]:matches)
        {
            set.add(k[0]);
            set.add(k[1]);
            lose.put(k[1],lose.getOrDefault(k[1],0)+1);
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp1=new ArrayList<>();
        List<Integer> temp2=new ArrayList<>();
        for(int k:set)
        {
            if(!lose.containsKey(k))
            {
                temp1.add(k);
            }
            if(lose.containsKey(k)&&lose.get(k)==1)
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