class pair{
    String s;
    int dis;
    public pair(String s,int dis)
    {
        this.s=s;
        this.dis=dis;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int res=-1;
        HashSet<String> set=new HashSet<>();
        for(String s:bank)
        {
            set.add(s);
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(startGene,0));
        while(!q.isEmpty())
        {
            pair curr=q.remove();
            String s=curr.s;
            int dis=curr.dis;
            if(s.equals(endGene))
            {
                return dis;
            }
            char arr[]={'A','C','G','T'};
            char gene[]=s.toCharArray();
            for(int i=0;i<gene.length;i++)
            {
                char orig=gene[i];
                for(int j=0;j<4;j++)
                {
                    if(gene[i]==arr[j])
                    {
                        continue;
                    }
                    gene[i]=arr[j];
                    String str=new String(gene);
                    if(set.contains(str))
                    {
                        set.remove(str);
                        q.add(new pair(str,dis+1));
                    }
                }
                gene[i]=orig;
            }
        }
        return res;
    }
}