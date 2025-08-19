class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++)
        {
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        int inc[]=new int[numCourses];
        for(int i=0;i<pre.length;i++)
        {
            inc[pre[i][0]]++;
        }
        List<Integer> l=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(inc[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int k=q.remove();
            l.add(k);
            for(int i:adj.get(k))
            {
                inc[i]--;
                if(inc[i]==0)
                {
                    q.add(i);
                }
            }
        }
        int res[]=new int[numCourses];
        if(l.size()==numCourses)
        {
            for(int i=0;i<numCourses;i++)
            {
                res[i]=l.get(i);
            }
            return res;
        }
        else
        {
            return new int[]{};
        }
    }
}