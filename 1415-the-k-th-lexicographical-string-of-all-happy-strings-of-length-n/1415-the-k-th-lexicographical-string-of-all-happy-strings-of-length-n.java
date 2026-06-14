class Solution {
    String res="";
    int count=0;
    private void backtrack(char a[],int n,int k,int i,StringBuilder sb){
        if(sb.length()==n){
            count++;
            if(count==k){
                res=sb.toString();
            }
            return;
        }
        for(int j=0;j<3;j++){
            if(i==0||(i>0&&sb.charAt(i-1)!=a[j])){
                sb.append(a[j]);
                backtrack(a,n,k,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        char a[]={'a','b','c'};
        backtrack(a,n,k,0,new StringBuilder());
        return res;
    }
}