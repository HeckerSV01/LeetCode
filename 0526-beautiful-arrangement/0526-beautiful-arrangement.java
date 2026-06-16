class Solution {
    int count=0;
    private void backtrack(int i,int n,boolean used[]){
        if(i==n){
            count++;
            return;
        }
        for(int j=1;j<=n;j++){
            if((j%(i+1)==0||(i+1)%j==0)&&!used[j-1]){
                used[j-1]=true;
                backtrack(i+1,n,used);
                used[j-1]=false;
            }
        }
    }
    public int countArrangement(int n) {
        boolean used[]=new boolean[n];
        backtrack(0,n,used);
        return count;
    }
}