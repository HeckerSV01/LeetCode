class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> l:knowledge)
        {
            map.put(l.get(0),l.get(1));
        }
        int st=-1;
        int en=-1;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                st=i+1;
                while(s.charAt(i)!=')')
                {
                    i++;
                }
                en=i;
                String key=s.substring(st,en);
                String finalst="";
                if(map.containsKey(key))
                {
                    finalst=map.get(key);
                }
                else
                {
                    finalst="?";
                }
                sb.append(finalst);
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}