class Solution {
    public long findScore(int[] nums) {
        TreeMap<Integer,PriorityQueue<Integer>> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],new PriorityQueue<>());
            }
            map.get(nums[i]).add(i);
        }
        long res=0;
        boolean[] marked=new boolean[nums.length];
        for(int val:map.keySet()) 
        {
            for(int idx:map.get(val)) 
            {
                if(!marked[idx]) 
                {
                    res=res+val;
                    marked[idx]=true;
                    if(idx-1>=0)
                    {
                        marked[idx-1]=true;
                    }
                    if(idx+1<nums.length) 
                    {
                        marked[idx+1]=true;
                    }
                }
            }
        }
        return res;
    }
}