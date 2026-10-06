class Solution {
    private String stripTrailing(String str) {
        int len = str.length();
        while (len > 0 && str.charAt(len - 1) == ' ') {
            len--;
        }
        return str.substring(0, len);
    }
    public List<String> printVertically(String s) {
        String a[]=s.split(" ");
        int maxlen=-1;
        for(String st:a){
            maxlen=Math.max(maxlen,st.length());
        }
        List<String> res=new ArrayList<>();
        for(int i=0;i<maxlen;i++){
            StringBuilder sb=new StringBuilder();
            for(String st:a){
                if(i<st.length()){
                    sb.append(st.charAt(i));
                }else{
                    sb.append(" ");
                }
            }
            res.add(stripTrailing(sb.toString()));
        }
        return res;
    }
}