class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        StringBuilder sb1=new StringBuilder(num1);
        StringBuilder sb2=new StringBuilder(num2);
        int idx1=sb1.indexOf("+");
        int idxx1=num1.length()-1;
        int idx2=sb2.indexOf("+");
        int idxx2=num2.length()-1;
        int re1=Integer.parseInt(sb1.substring(0,idx1));
        int re2=Integer.parseInt(sb2.substring(0,idx2));
        int img1=Integer.parseInt(sb1.substring(idx1+1,idxx1));
        int img2=Integer.parseInt(sb2.substring(idx2+1,idxx2));
        int res1=(re1*re2)-(img1*img2);
        int res2=(re1*img2)+(re2*img1);
        return String.valueOf(res1)+"+"+String.valueOf(res2)+"i";
    }
}