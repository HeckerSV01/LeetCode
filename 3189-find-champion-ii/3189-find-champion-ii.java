class Solution {
    public int findChampion(int n, int[][] edges) {
        int check[]=new int[n];
        for(int i=0;i<edges.length;i++)
        {
            check[edges[i][1]]=1;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(check[i]==0)
            {
                list.add(i);
            }
        }
        if(list.size()>1)
        {
            return -1;
        }
        return list.get(0);
    }
}