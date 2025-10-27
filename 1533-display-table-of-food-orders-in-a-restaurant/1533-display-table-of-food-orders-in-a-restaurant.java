class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<Integer> tables=new TreeSet<>();
        TreeSet<String> food=new TreeSet<>();
        HashMap<Integer,HashMap<String,Integer>> map=new HashMap<>();
        for(List<String> l:orders)
        {
            int tableno=Integer.parseInt(l.get(1));
            String st=l.get(2);
            tables.add(tableno);
            food.add(st);
            if(!map.containsKey(tableno))
            {
                map.put(tableno,new HashMap<>());
            }
            map.get(tableno).put(st,map.get(tableno).getOrDefault(st,0)+1);
        }
        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        list.add("Table");
        for(String s:food)
        {
            list.add(s);
        }
        res.add(list);
        for(int k:tables)
        {
            List<String> l=new ArrayList<>();
            l.add(String.valueOf(k));
            for(String s:food)
            {
                if(!map.get(k).containsKey(s))
                {
                    l.add("0");
                }
                else
                {
                    l.add(String.valueOf(map.get(k).get(s)));
                }
            }
            res.add(l);
        }
        return res;
    }
}