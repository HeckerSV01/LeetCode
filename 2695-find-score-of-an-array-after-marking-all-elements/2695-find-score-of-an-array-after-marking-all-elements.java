class Solution {
    public long findScore(int[] nums) {
        TreeMap<Integer,PriorityQueue<Integer>> map=new TreeMap<>();
        HashSet<Integer> marked=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],new PriorityQueue<>());
            }
            map.get(nums[i]).add(i);
        }
        long res=0;
        while(marked.size()<nums.length)
        {
            for(int k:map.keySet())
            {
                for(int i:map.get(k))
                {
                    if(!marked.contains(i))
                    {
                        marked.add(i);
                        res=res+nums[i];
                        if(i+1<=nums.length-1)
                        {
                            marked.add(i+1);
                        }
                        if(i-1>=0)
                        {
                            marked.add(i-1);
                        }
                    }
                }
            }
        }
        return res;
    }
}