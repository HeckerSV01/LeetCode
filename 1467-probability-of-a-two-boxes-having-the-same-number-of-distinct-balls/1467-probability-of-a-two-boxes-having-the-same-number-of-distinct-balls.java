class Solution {
    int half;
    double count=0;
    double total=0;
    private long factorial(int n){
        long res=1;
        for(int i=1;i<=n;i++){
            res*=i;
        }
        return res;
    }
    private double combination(int n,int r){
        return (double)(factorial(n)/(factorial(r)*factorial(n-r)));
    }
    private void solve(int i,int box1,int balls[],int distinct1,int distinct2,double ways){
        if(box1>half){
            return;
        }
        if(i==balls.length){
            if(box1==half){
                total+=ways;
                if(distinct1==distinct2){
                    count+=ways;
                }
            }
            return;
        }
        for(int j=0;j<=balls[i];j++){
            solve(i+1,box1+j,balls,distinct1+((j>0)?1:0),distinct2+((j<balls[i])?1:0),ways*combination(balls[i],j));
        }
    }
    public double getProbability(int[] balls) {
        int sum=0;
        for(int k:balls){
            sum+=k;
        }
        half=sum/2;
        solve(0,0,balls,0,0,1);
        return (double)count/total;
    }
}