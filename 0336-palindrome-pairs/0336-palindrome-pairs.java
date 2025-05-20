class Solution {
    public boolean palin(String s)
    {
        int l=0,r=s.length()-1;
        while(l<r) 
        {
            if(s.charAt(l++)!=s.charAt(r--))
            {
             return false;
            }
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        if(words==null||words.length==0)
        {
            return res;
        }
        for(int i=0;i<words.length;i++)
        {
            map.put(words[i],i);
        }
        if(map.containsKey(""))
        {
            int idx=map.get("");
            for(int i=0;i<words.length;i++)
            {
                if(palin(words[i])&&i!=idx)
                {
                    res.add(Arrays.asList(i,idx));
                    res.add(Arrays.asList(idx,i));
                }
            }
        }
        for(int i=0;i<words.length;i++)
        {
            String rev=new StringBuilder(words[i]).reverse().toString();
            Integer idx=map.get(rev);
            if(idx!=null&&idx!=i)
            {
                res.add(Arrays.asList(i,idx));
            }
        }
        for(int i=0;i<words.length;i++)
        {
            String st=words[i];
            for(int j=1;j<st.length();j++)
            {
                String left=st.substring(0,j);
                String right=st.substring(j);
                if(palin(left))
                {
                    String revright=new StringBuilder(right).reverse().toString();
                    Integer idx=map.get(revright);
                    if(idx!=null&&idx!=i)
                    {
                        res.add(Arrays.asList(idx,i));
                    }
                }
                if(palin(right))
                {
                    String revleft=new StringBuilder(left).reverse().toString();
                    Integer idx=map.get(revleft);
                    if(idx!=null&&idx!=i)
                    {
                        res.add(Arrays.asList(i,idx));
                    }
                }
            }
        }
        return res;
    }
}