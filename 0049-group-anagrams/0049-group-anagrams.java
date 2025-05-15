class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        List<List<String>> l=new ArrayList<>();
        for(int i=0;i<strs.length;i++)
        {
            String st=strs[i];
            char ch[]=st.toCharArray();
            Arrays.sort(ch);
            String finalst=new String(ch);
            if(!map.containsKey(finalst))
            {
                map.put(finalst,new ArrayList<>());
            }
            map.get(finalst).add(st);
        }
        l.addAll(map.values());
        return l;
    }
}