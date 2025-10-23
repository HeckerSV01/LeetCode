class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int res[]=new int[A.length];
        for(int i=0;i<A.length;i++)
        {
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<=i;j++)
            {
                map.put(A[j],map.getOrDefault(A[j],0)+1);
                map.put(B[j],map.getOrDefault(B[j],0)+1);
            }
            int count=0;
            for(int k:map.keySet())
            {
                if(map.get(k)>1)
                {
                    count++;
                }
            }
            res[i]=count;
        }
        return res;
    }
}