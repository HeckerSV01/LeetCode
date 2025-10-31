class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<word.length();i++)
        {
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }
        int min=Integer.MAX_VALUE;
        List<Integer> list=new ArrayList<>();
        for(int i:map.values())
        {
            list.add(i);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++)
        {
            int sum=0;
            for(int j=0;j<list.size();j++)
            {
                if(list.get(j)>list.get(i)+k)
                {
                    sum=sum+list.get(j)-list.get(i)-k;
                }
                else if(list.get(j)<list.get(i))
                {
                    sum=sum+list.get(j);
                }
            }
            if(sum<min)
            {
                min=sum;
            }
        }
        return min;
    }
}