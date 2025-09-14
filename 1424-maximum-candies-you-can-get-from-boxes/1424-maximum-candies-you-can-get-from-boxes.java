class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] contained, int[] initial) {
        Queue<Integer> q=new LinkedList<>();
        int hasbox[]=new int[status.length];
        int opened[]=new int[status.length];
        int res=0;
        for(int i=0;i<initial.length;i++)
        {
            hasbox[initial[i]]=1;
            if(status[initial[i]]==1)
            {
                q.add(initial[i]);
            }
        }
        while(!q.isEmpty())
        {
            int curr=q.remove();
            if(opened[curr]==1)
            {
                continue;
            }
            res=res+candies[curr];
            opened[curr]=1;
            for(int k:keys[curr])
            {
                if(status[k]==0)
                {
                    status[k]=1;
                    if(hasbox[k]==1)
                    {
                        q.add(k);
                    }
                }
            }
            for(int k:contained[curr])
            {
                hasbox[k]=1;
                if(status[k]==1)
                {
                    q.add(k);
                }
            }
        }
        return res;
    }
}