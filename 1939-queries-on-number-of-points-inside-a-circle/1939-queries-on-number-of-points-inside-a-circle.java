class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int res[]=new int[queries.length];
        int k=0;
        for(int i[]:queries)
        {
            int count=0;
            for(int j[]:points)
            {
                if(Math.pow(j[0]-i[0],2)+Math.pow(j[1]-i[1],2)<=Math.pow(i[2],2))
                {
                    count++;
                }
            }
            res[k++]=count;
        }
        return res;
    }
}