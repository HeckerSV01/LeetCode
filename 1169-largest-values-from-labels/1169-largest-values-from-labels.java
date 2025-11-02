class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int a[][]=new int[values.length][2];
        for(int i=0;i<values.length;i++)
        {
            a[i][0]=values[i];
            a[i][1]=labels[i];
        }
        Arrays.sort(a,(b,c)->c[0]-b[0]);
        int count=0;
        int res=0;
        for(int i=0;i<a.length&&count<numWanted;i++)
        {
            map.putIfAbsent(a[i][1],0);
            if(map.get(a[i][1])<useLimit)
            {
                res=res+a[i][0];
                count++;
                map.put(a[i][1],map.get(a[i][1])+1);
            }
        }
        return res;
    }
}