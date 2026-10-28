class Solution {
    int res=Integer.MIN_VALUE;
    private boolean check(int in[],int out[]){
        for(int i=0;i<in.length;i++){
            if(in[i]!=out[i]){
                return false;
            }
        }
        return true;
    }
    private void backtrack(int n,int req[][],int i,int incoming[],int outgoing[],int count){
        if(i==req.length){
            if(check(incoming,outgoing)){
                res=Math.max(res,count);
            }
            return;
        }
        outgoing[req[i][0]]++;
        incoming[req[i][1]]++;
        backtrack(n,req,i+1,incoming,outgoing,count+1);
        outgoing[req[i][0]]--;
        incoming[req[i][1]]--;
        backtrack(n,req,i+1,incoming,outgoing,count);
    }
    public int maximumRequests(int n, int[][] requests) {
        int incoming[]=new int[n];
        int outgoing[]=new int[n];
        backtrack(n,requests,0,incoming,outgoing,0);
        return res;
    }
}