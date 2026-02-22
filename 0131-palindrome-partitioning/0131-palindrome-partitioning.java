class Solution {
    private boolean ispalin(String s){

        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    private void backtrack(String s,List<String> list,List<List<String>> res,int i){
        if(i==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<s.length();j++){
            String str=s.substring(i,j+1);
            if(ispalin(str)){
                list.add(str);
                backtrack(s,list,res,j+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backtrack(s,new ArrayList<>(),res,0);
        return res;
    }
}