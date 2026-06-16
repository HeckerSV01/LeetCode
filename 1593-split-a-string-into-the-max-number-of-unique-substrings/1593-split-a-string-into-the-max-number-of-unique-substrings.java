class Solution {
    int res=Integer.MIN_VALUE;
    private void backtrack(String s,int i,HashSet<String> set){
        if(i==s.length()){
            res=Math.max(res,set.size());
            return;
        }
        for(int j=i+1;j<=s.length();j++){
            String str=s.substring(i,j);
            if(!set.contains(str)){
                set.add(str);
                backtrack(s,j,set);
                set.remove(str);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        HashSet<String> set=new HashSet<>();
        backtrack(s,0,set);
        return res;
    }
}