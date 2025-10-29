class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<grid.length;i++)
        {
            String s=Arrays.toString(grid[i]);
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int res=0;
        for(int i=0;i<grid.length;i++)
        {
            int a[]=new int[grid.length];
            for(int j=0;j<grid.length;j++)
            {
                a[j]=grid[j][i];
            }
            String s=Arrays.toString(a);
            if(map.containsKey(s))
            {
                res=res+map.get(s);
            }
        }
        return res;
    }
}