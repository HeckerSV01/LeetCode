class SummaryRanges {
 TreeSet<Integer> set;
    public SummaryRanges() {
        set=new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        List<Integer> list=new ArrayList<>();
        for(int k:set)
        {
            list.add(k);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            int st=list.get(i);
            int en=list.get(i);
            while(i<list.size()-1&&list.get(i+1)==list.get(i)+1)
            {
                i++;
                en=list.get(i);
            }
            List<Integer> l=new ArrayList<>();
            l.add(st);
            l.add(en);
            res.add(l);
        }
        int a[][]=new int[res.size()][2];
        for(int i=0;i<res.size();i++)
        {
            a[i][0]=res.get(i).get(0);
            a[i][1]=res.get(i).get(1);
        }
        return a;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */