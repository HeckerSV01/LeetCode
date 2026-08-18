class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int a[][]=new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            a[i][0]=profits[i];
            a[i][1]=capital[i];
        }
        Arrays.sort(a,(x,y)->x[1]-y[1]);
        int i=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        while(k>0){
            while(i<profits.length&&w>=a[i][1]){
                pq.offer(a[i][0]);
                i++;
            }
            if(pq.isEmpty()){
                break;
            }
            w=w+pq.poll();
            k--;
        }
        return w;
    }
}