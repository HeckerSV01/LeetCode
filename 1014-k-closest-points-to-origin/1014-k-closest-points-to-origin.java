class Solution {
    public static double dist(int a[])
        {
            return Math.sqrt(Math.pow(a[0],2)+Math.pow(a[1],2));
        }
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a, b)->Double.compare(dist(a),dist(b))
       ); 
       for(int a[]:points)
       {
        pq.add(a);
       }
       int res[][]=new int[k][2];
       for(int i=0;i<k;i++)
       {
        res[i]=pq.remove();
       }
       return res;
    }
}