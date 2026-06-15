class Solution {
    private String swap(String s,int i1,int i2){
        StringBuilder sb=new StringBuilder(s);
        char temp=sb.charAt(i1);
        sb.setCharAt(i1,sb.charAt(i2));
        sb.setCharAt(i2,temp);
        return sb.toString();
    }
    public int slidingPuzzle(int[][] board) {
        final String target="123450";
        String start="";
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                start=start+board[i][j];
            }
        }
        final int dir[][]={{1,3},{0,2,4},{1,5},{0,4},{3,5,1},{4,2}};
        Queue<String> q=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        q.offer(start);
        vis.add(start);
        int res=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                String s=q.poll();
                if(s.equals(target)){
                    return res;
                }
                int idx=s.indexOf('0');
                for(int d:dir[idx]){
                    String st=swap(s,idx,d);
                    if(vis.contains(st)){
                        continue;
                    }
                    vis.add(st);
                    q.offer(st);
                }
            }
            res++;
        }
        return -1;
    }
}