class Node{
    int num;
    int seq;
    int wt;
    public Node(int num,int seq,int wt){
        this.num=num;
        this.seq=seq;
        this.wt=wt;
    }
}
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
        }
        int best[][]=new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        best[0][1]=0;
        pq.offer(new Node(0,1,0));
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int curnode=cur.num;
            int curwt=cur.wt;
            int curseq=cur.seq;
            if(curwt>best[curnode][curseq]){
                continue;
            }
            if(curnode==n-1){
                return curwt;
            }
            for(int e[]:adj.get(curnode)){
                int adjnode=e[0];
                int adjwt=e[1];
                int newseq=(labels.charAt(adjnode)==labels.charAt(curnode))?curseq+1:1;
                if(newseq<=k&&adjwt+curwt<best[adjnode][newseq]){
                    best[adjnode][newseq]=adjwt+curwt;
                    pq.offer(new Node(adjnode,newseq,curwt+adjwt));
                }
            }
        }
        return -1;
    }
}