class Solution {
    public int numSteps(String s) {
        StringBuilder sb=new StringBuilder(s);
        int res=0;
        while(sb.length()>1){
            if(sb.charAt(sb.length()-1)=='0'){
                sb.deleteCharAt(sb.length()-1);
                res++;
            }else{
                int i=sb.length();
                for(i=sb.length()-1;i>=0;i--){
                    if(sb.charAt(i)=='0'){
                        sb.setCharAt(i,'1');
                        break;
                    }else{
                        sb.setCharAt(i,'0');
                    }
                }
                if(i<0){
                    sb.insert(0,'1');
                }
                res++;
            }
        }
        return res;
    }
}