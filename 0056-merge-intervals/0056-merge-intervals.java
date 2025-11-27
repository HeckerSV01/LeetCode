class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            int st=intervals[i][0];
            int en=intervals[i][1];
            while(i<intervals.length-1&&intervals[i+1][0]<=en)
            {
                en=Math.max(en,intervals[i+1][1]);
                i++;
            }
            List<Integer> list=new ArrayList<>();
            list.add(st);
            list.add(en);
            res.add(new ArrayList(list));
        }
        int mat[][]=new int[res.size()][2];
        for(int i=0;i<res.size();i++)
        {
            for(int j=0;j<2;j++)
            {
                mat[i][j]=res.get(i).get(j);
            }
        }
        return mat;
    }
}