class Solution {
    public int minFlips(String target) {
        int res=0;
        int temp=target.charAt(target.length()-1)-'0';
        for(int i=target.length()-2;i>=0;i--){
            if(target.charAt(i)-'0'!=temp){
                temp=target.charAt(i)-'0';
                res++;
            }
        }
        return (temp==0)?res:res+1;
    }
}