class Solution {
    public int[][] insert(int[][] intervals, int[] inter) {
        int idx=intervals.length;
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]>=inter[0])
            {
                idx=i;
                break;
            }
        }
        ArrayList<int[]> res=new ArrayList<>();
        int st=inter[0];
        int en=inter[1];
        int i=idx-1;
        while(i>=0&&intervals[i][1]>=st)
        {
            st=Math.min(intervals[i][0],st);
            en=Math.max(en,intervals[i][1]);
            i--;
        }
        int j=idx;
        while(j<intervals.length&&intervals[j][0]<=en)
        {
            st=Math.min(intervals[j][0],st);
            en=Math.max(en,intervals[j][1]);
            j++;
        }
        for(int k=0;k<=i;k++)
        {
            res.add(new int[]{intervals[k][0],intervals[k][1]});
        }
        res.add(new int[]{st,en});
        for(int k=j;k<intervals.length;k++)
        {
            res.add(new int[]{intervals[k][0],intervals[k][1]});
        }
        int mat[][]=new int[res.size()][2];
        for(int k=0;k<res.size();k++)
        {
            mat[k][0]=res.get(k)[0];
            mat[k][1]=res.get(k)[1];
        }
        return mat;
    }
}