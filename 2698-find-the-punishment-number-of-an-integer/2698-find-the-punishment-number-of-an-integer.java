class Solution {
    private boolean check(int i){
        if(partition(String.valueOf(i*i),0,i)){
            return true;
        }
        return false;
    }
    private boolean partition(String s,int i,int goal){
        if(i==s.length()){
            return goal==0;
        }
        if(goal<0) {
            return false;
        }
        for(int j=i;j<s.length();j++){
            int temp=Integer.parseInt(s.substring(i,j+1));
            goal-=temp;
            if(partition(s,j+1,goal)){
                return true;
            }
            goal+=temp;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            if(check(i)){
                res+=i*i;
            }
        }
        return res;
    }
}