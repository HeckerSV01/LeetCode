class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Double.compare(
        ((double)(b[0] + 1) / (b[1] + 1)) - ((double)b[0] / b[1]),
        ((double)(a[0] + 1) / (a[1] + 1)) - ((double)a[0] / a[1])
    ));
        for(int k[]:classes)
        {
            pq.add(k);
        }
        for(int i=1;i<=extraStudents;i++)
        {
            int cur[]=pq.remove();
            pq.add(new int[]{cur[0]+1,cur[1]+1});
        }
        double sum=0.0;
        while(!pq.isEmpty())
        {
            int k[]=pq.remove();
            sum=sum+(double)k[0]/k[1];
        }
        return sum/classes.length;
    }
}