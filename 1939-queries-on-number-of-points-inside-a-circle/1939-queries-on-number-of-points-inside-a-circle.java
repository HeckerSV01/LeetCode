class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int res[]=new int[queries.length];
        int k=0;
        for(int i[]:queries)
        {
            int count=0;
            for(int j[]:points)
            {
                if((j[0]-i[0])*(j[0]-i[0])+(j[1]-i[1])*(j[1]-i[1])<=i[2]*i[2])
                {
                    count++;
                }
            }
            res[k++]=count;
        }
        return res;
    }
}