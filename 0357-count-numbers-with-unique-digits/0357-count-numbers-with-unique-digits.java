class Solution {
    private int solve(int n,boolean used[],int max,int prev){
        int count=0;
        if(prev<max){
            count++;
        }else{
            return count;
        }
        for(int j=0;j<10;j++){
            if(!used[j]){
                used[j]=true;
                int curr=prev*10+j;
                count+=solve(n,used,max,curr);
                used[j]=false;
            }
        }
        return count;
    }
    public int countNumbersWithUniqueDigits(int n) {
        int count=1;
        boolean used[]=new boolean[10];
        int max=(int)Math.pow(10,n);
        for(int i=1;i<10;i++){
            used[i]=true;
            count+=solve(n,used,max,i);
            used[i]=false;
        }
        return count;
    }
}