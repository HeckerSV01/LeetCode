class Solution {
    public void recur(List<String> res,int open,int close,int size,String s)
    {
        if(open==close&&open+close==size*2)
        {
            res.add(s);
            return;
        }
        if(open<size)
        {
            recur(res,open+1,close,size,s+"(");
        }
        if(close<open)
        {
            recur(res,open,close+1,size,s+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        String s="";
        recur(res,0,0,n,"");
        return res;        
    }
}