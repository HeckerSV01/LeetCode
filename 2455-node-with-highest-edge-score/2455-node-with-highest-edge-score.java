class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer,Long> map=new HashMap<>();
        for(int i=0;i<edges.length;i++)
        {
            map.put(edges[i],map.getOrDefault(edges[i],0L)+i);
        }
        long max=-1;
        int res=0;
        for(int k:map.keySet()) 
        {
            long val=map.get(k);
            if(val>max||(val==max&&k<res)) 
            {
                max = val;
                res = k;
            }
        }
        return res;
    }
}