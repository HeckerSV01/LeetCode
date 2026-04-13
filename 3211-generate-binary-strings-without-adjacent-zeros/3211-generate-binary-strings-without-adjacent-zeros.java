class Solution {
    private void backtrack(int n,int i,List<String> res,char prev,StringBuilder sb){
        if(i==n){
            res.add(sb.toString());
            return;
        }
        if(prev=='0'){
            sb.append('1');
            backtrack(n,i+1,res,'1',sb);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append('0');
            backtrack(n,i+1,res,'0',sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append('1');
            backtrack(n,i+1,res,'1',sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> validStrings(int n) {
        List<String> res=new ArrayList<>();
        backtrack(n,1,res,'0',new StringBuilder("0"));
        backtrack(n,1,res,'1',new StringBuilder("1"));
        return res;
    }
}