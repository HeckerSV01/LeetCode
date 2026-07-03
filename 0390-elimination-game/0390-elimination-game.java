class Solution {
    int res=0;
    private void recur(int first,int last,int n,boolean toggle,int step){
        if(n<2){
            res=first;
            return;
        }
        if(toggle){
            if(n%2==0){
                recur(first+step,last,n/2,!toggle,step*2);
            }else{
                recur(first+step,last-step,n/2,!toggle,step*2);
            }
        }else{
            if(n%2==0){
                recur(first,last-step,n/2,!toggle,step*2);
            }else{
                recur(first+step,last-step,n/2,!toggle,step*2);
            }
        }
    }
    public int lastRemaining(int n) {
        recur(1,n,n,true,1);
        return res;
    }
}