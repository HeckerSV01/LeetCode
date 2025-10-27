class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer> map=new HashMap<>();
        for(List<String> l:responses)
        {
            HashSet<String> set=new HashSet<>();
            for(String s:l)
            {
                set.add(s);
            }
            for(String s:set)
            {
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        String res="";
        int max=Integer.MIN_VALUE;
        for(String s:map.keySet())
        {
            if(map.get(s)>max)
            {
                max=map.get(s);
                res=s;
            }
            else if(map.get(s)==max&&s.compareTo(res)<0)
            {
                res=s;
            }
        }
        return res;
    }
}