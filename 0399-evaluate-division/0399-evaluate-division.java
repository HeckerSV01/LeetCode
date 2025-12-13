class pair{
    String val;
    double wt;
    public pair(String val,double wt)
    {
        this.val=val;
        this.wt=wt;
    }
}
class Solution {
    double ans;
    public void dfs(HashMap<String,List<pair>> adj,String s1,String s2,HashSet<String> vis,double d)
    {
        if(vis.contains(s1))
        {
            return;
        }
        vis.add(s1);
        if(s1.equals(s2))
        {
            ans=d;
            return;
        }
        for(pair p:adj.get(s1))
        {
            if(ans!=-1.0)
            {
                return;
            }
            dfs(adj,p.val,s2,vis,d*p.wt);
        }
    }
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) { 
        HashMap<String,List<pair>> adj=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<eq.size();i++)
        {
            if(!adj.containsKey(eq.get(i).get(1)))
            {
                adj.put(eq.get(i).get(1),new ArrayList<>());
            }
            adj.get(eq.get(i).get(1)).add(new pair(eq.get(i).get(0),values[i]));
            if(!adj.containsKey(eq.get(i).get(0)))
            {
                adj.put(eq.get(i).get(0),new ArrayList<>());
            }
            adj.get(eq.get(i).get(0)).add(new pair(eq.get(i).get(1),1.0/values[i]));
            set.add(eq.get(i).get(0));
            set.add(eq.get(i).get(1));
        }
        double res[]=new double[queries.size()];
        for(int i=0;i<queries.size();i++)
        {
            String s1=queries.get(i).get(0);
            String s2=queries.get(i).get(1);
            if(!set.contains(s1)||!set.contains(s2))
            {
                res[i]=-1.0;
                continue;
            }
            if(s1.equals(s2))
            {
                res[i]=1.0;
                continue;
            }
            ans=-1.0;
            HashSet<String> vis=new HashSet<>();
            dfs(adj,s2,s1,vis,1.0);
            res[i]=ans;
        }
        return res;
    }
}