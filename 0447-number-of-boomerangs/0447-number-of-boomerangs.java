class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    continue;
                }
                int dis=(int)Math.pow(points[j][0]-points[i][0],2)+(int)Math.pow(points[j][1]-points[i][1],2);
                map.put(dis,map.getOrDefault(dis,0)+1);
            } 
            for(int k:map.values())
            {
                res=res+k*(k-1);
            }
        }
        return res;
    }
}