class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> set=new HashSet<>();
        for(int k:nums)
        {
            set.add(k);
        }
        int i=0;
        while(i<moveFrom.length)
        {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
            i++;
        }
        List<Integer> res=new ArrayList<>();
        for(int k:set)
        {
            res.add(k);
        }
        Collections.sort(res);
        return res;
    }
}