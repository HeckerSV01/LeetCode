class Solution {
    public int passwordStrength(String password) {
        HashSet<Character> set=new HashSet<>();
        for(char c:password.toCharArray()){
            set.add(c);
        } 
        int res=0;
        for(char c:set){
            if(c>='a'&&c<='z'){
                res=res+1;
            }else if(c>='A'&&c<='Z'){
                res=res+2;
            }else if(c>='0'&&c<='9'){
                res=res+3;
            }else{
                res=res+5;
            }
        }
        return res;
    }
}