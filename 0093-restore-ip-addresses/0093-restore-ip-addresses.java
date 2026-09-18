class Solution {
    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        long val = Long.parseLong(s);
        return val >= 0 && val <= 255;
    }
    public List<String> restoreIpAddresses(String s) {
        int n=s.length();
        List<String> res=new ArrayList<>();
        for(int i=1;i<=3&&i<n;i++){
            for(int j=1;j<=3&&i+j<n;j++){
                for(int k=1;k<=3&&i+j+k<n;k++){
                    String a=s.substring(0,i);
                    String b=s.substring(i,i+j);
                    String c=s.substring(i+j,i+j+k);
                    String d=s.substring(i+j+k,n);
                    if(isValid(a)&&isValid(b)&&isValid(c)&&isValid(d)){
                        res.add(a+"."+b+"."+c+"."+d);
                    }
                }
            }
        }
        return res;
    }
}