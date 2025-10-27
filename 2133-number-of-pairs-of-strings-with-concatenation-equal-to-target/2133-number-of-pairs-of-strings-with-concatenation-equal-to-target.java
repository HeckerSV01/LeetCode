class Solution {
    public int numOfPairs(String[] nums, String target) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:nums)
        {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int count=0;
        for(String s:nums)
        {
            if(target.startsWith(s))
            {
                String st=target.substring(s.length());
                if(map.containsKey(st))
                {
                    count=count+map.get(st);
                    if(st.equals(s))
                    {
                        count--;
                    }
                }
            }
        }
        return count;
    }
}