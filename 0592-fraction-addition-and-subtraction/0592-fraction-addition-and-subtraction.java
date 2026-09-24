class num{
    int numerator;
    int denominator;
    public num(int numerator,int denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }
}
class Solution {
    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
    public String fractionAddition(String expression) {
        String signst="";
        if(expression.charAt(0)=='-'){
            signst=signst+"-";
        }else{
            signst=signst+"+";
        }
        for(int i=1;i<expression.length();i++){
            if(expression.charAt(i)=='+'){
                signst=signst+"+";
            }else if(expression.charAt(i)=='-'){
                signst=signst+"-";
            }
        }
        if (expression.charAt(0) == '+' || expression.charAt(0) == '-') {
            expression = expression.substring(1);
        }
        String frac[]=expression.split("[\\+-]");
        List<num> pos=new ArrayList<>();
        List<num> neg=new ArrayList<>();
        for (int i = 0; i < frac.length; i++) {

            String parts[] = frac[i].split("/");

            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);

            if (signst.charAt(i) == '+') {
                pos.add(new num(numerator, denominator));
            } else {
                neg.add(new num(numerator, denominator));
            }
        }
        int sum1n=0;
        int sum1d=1;
        for(num n:pos){
            int tempn=(sum1n*n.denominator)+(n.numerator*sum1d);
            int tempd=sum1d*n.denominator;
            int cf=gcd(tempn,tempd);
            tempn=tempn/cf;
            tempd=tempd/cf;
            sum1n=tempn;
            sum1d=tempd;
        }
        int sum2n=0;
        int sum2d=1;
        for(num n:neg){
            int tempn=(sum2n*n.denominator)+(n.numerator*sum2d);
            int tempd=sum2d*n.denominator;
            int cf=gcd(tempn,tempd);
            tempn=tempn/cf;
            tempd=tempd/cf;
            sum2n=tempn;
            sum2d=tempd;
        }
        if(sum1n*sum2d>sum2n*sum1d){
            int resn=(sum1n*sum2d)-(sum2n*sum1d);
            int resd=sum1d*sum2d;
            int cf=gcd(resn,resd);
            resn=resn/cf;
            resd=resd/cf;
            return new String(String.valueOf(resn)+"/"+String.valueOf(resd));
        }else if(sum1n*sum2d<sum2n*sum1d){
            int resn=(sum2n*sum1d)-(sum1n*sum2d);
            int resd=sum1d*sum2d;
            int cf=gcd(resn,resd);
            resn=resn/cf;
            resd=resd/cf;
            return new String("-"+String.valueOf(resn)+"/"+String.valueOf(resd));
        }else{
            return "0/1";
        }
    }
}