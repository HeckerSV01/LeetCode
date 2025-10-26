class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:cpdomains)
        {
            String a[]=s.split(" "); 
            String st=a[1];
            map.put(a[1],map.getOrDefault(a[1],0)+Integer.parseInt(a[0]));
            for(int i=0;i<st.length();i++)
            {
                if(st.charAt(i)=='.')
                {
                    String str=st.substring(i+1);
                    map.put(str,map.getOrDefault(str,0)+Integer.parseInt(a[0]));
                }
            }
        }
        List<String> res=new ArrayList<>();
        for(String s:map.keySet())
        {
            String st=map.get(s)+" "+s;
            res.add(st);
        }
        return res;
    }
}