class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++)
        {
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int res=0;
        for(int k:map.keySet())
        {
            if(map.get(k)<2)
            {
                return -1;
            }
            res=res+(map.get(k)+2)/3;
        }
        return res;
    }
}