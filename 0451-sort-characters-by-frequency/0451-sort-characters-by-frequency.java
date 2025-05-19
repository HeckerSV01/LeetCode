class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Map.Entry<Character,Integer>> list=new LinkedList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2) {
            return o2.getValue()-o1.getValue(); 
    }
    });
        HashMap<Character,Integer> temp=new LinkedHashMap<Character,Integer>();
        for (Map.Entry<Character,Integer> aa:list) {
            temp.put(aa.getKey(),aa.getValue());
        }
         StringBuilder res=new StringBuilder();
        for(Character key:temp.keySet())
        {
            res.append(String.valueOf(key).repeat(temp.get(key)));
        }
        return res.toString();
    }
}