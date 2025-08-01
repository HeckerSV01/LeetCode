class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        l1.add(1);
        res.add(l1);
        for(int i=1;i<numRows;i++)
        {
            List<Integer> row=new ArrayList<>();
            row.add(1);
            List<Integer> prev=res.get(i-1);
            for(int j=1;j<i;j++)
            {
                row.add(prev.get(j-1)+prev.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}