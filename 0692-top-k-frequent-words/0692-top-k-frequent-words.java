class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<String> res=new ArrayList<>();
        for(String s:words)
        {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() 
        {
            public int compare(String a,String b) 
            { 
                if(map.get(a).equals(map.get(b))) 
                {
                    return a.compareTo(b); 
                } 
                else 
                {
                    return map.get(b)-map.get(a);
                } 
            }
        });
        for(String key:map.keySet()) 
        {
            pq.add(key);
        }
        for(int i=0;i<k;i++)
        {
            res.add(pq.remove());
        }
        return res;
    }
}