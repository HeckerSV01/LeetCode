class Solution {
    private void solve(int n,int k,List<Integer> list,StringBuilder sb,int lastdigit){
        if(sb.length()==n){
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i=0;i<=9;i++){
            if(lastdigit+k==i){
                sb.append(i);
                solve(n,k,list,sb,i);
                sb.deleteCharAt(sb.length()-1);
            }else if(lastdigit-k==i){
                sb.append(i);
                solve(n,k,list,sb,i);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=9;i++){
            sb.append(i);
            solve(n,k,list,sb,i);
            sb.deleteCharAt(sb.length()-1);
        }
        int res[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}