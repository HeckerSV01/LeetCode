class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<senders.length;i++)
        {
            int count=0;
            for(int j=0;j<messages[i].length();j++)
            {
                if(messages[i].charAt(j)==' ')
                {
                    count++;
                }
            }
            int k=count+1;
            map.put(senders[i],map.getOrDefault(senders[i],0)+k);
        }
        int maxvalue=Integer.MIN_VALUE;
        for(int k:map.values())
        {
            maxvalue=Math.max(maxvalue,k);
        }
        List<String> list=new ArrayList<>();
        for(String s:map.keySet())
        {
            if(map.get(s)==maxvalue)
            {
                list.add(s);
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}