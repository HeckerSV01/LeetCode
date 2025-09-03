class disjointSet{
    public List<Integer> parent=new ArrayList<>();
    public List<Integer> size=new ArrayList<>();
    public disjointSet(int n)
    {
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int find(int node)
    {
        if(node==parent.get(node))
        {
            return node;
        }
        int ultparent=find(parent.get(node));
        parent.set(node,ultparent);
        return parent.get(node);
    }
    public void unionbysize(int u,int v)
    {
        int ultofu=find(u);
        int ultofv=find(v);
        if(ultofu==ultofv)
        {
            return;
        }
        if(size.get(ultofu)<size.get(ultofv))
        {
            parent.set(ultofu,ultofv);
            size.set(ultofv,size.get(ultofv)+size.get(ultofu));
        }
        else
        {
            parent.set(ultofv,ultofu);
            size.set(ultofu,size.get(ultofu)+size.get(ultofv));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        disjointSet ds=new disjointSet(n);
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            List<String> l=accounts.get(i);
            for(int j=1;j<l.size();j++)
            {
                if(!map.containsKey(l.get(j)))
                {
                    map.put(l.get(j),i);
                }
                else
                {
                    ds.unionbysize(map.get(l.get(j)),i);
                }
            }
        }
        List<List<String>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for(String s:map.keySet())
        {
            int node=map.get(s);
            int ultp=ds.find(node);
            list.get(ultp).add(s);
        }
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(list.get(i).size()==0)
            {
                continue;
            }
            Collections.sort(list.get(i));
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String k:list.get(i))
            {
                temp.add(k);
            }
            res.add(temp);
        }
        return res;
    }
}