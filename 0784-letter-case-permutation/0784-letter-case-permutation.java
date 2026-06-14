class Solution {
    private void backtrack(StringBuilder sb,int i,List<String> res){
        if(i==sb.length()){
            res.add(sb.toString());
            return;
        }
        char c=sb.charAt(i);
        if(c>='a'&&c<='z'){
            sb.setCharAt(i,Character.toUpperCase(c));
            backtrack(sb,i+1,res);
            sb.setCharAt(i,c);
            backtrack(sb,i+1,res);
        }else if(c>='A'&&c<='Z'){
            sb.setCharAt(i,Character.toLowerCase(c));
            backtrack(sb,i+1,res);
            sb.setCharAt(i,c);
            backtrack(sb,i+1,res);
        }
        else{
            backtrack(sb,i+1,res);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> res=new ArrayList<>();
        backtrack(new StringBuilder(s),0,res);
        return res;
    }
}