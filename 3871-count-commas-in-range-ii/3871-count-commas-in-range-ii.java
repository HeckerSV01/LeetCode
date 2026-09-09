class Solution {
    public long countCommas(long n) {
        if(n<1000){
            return 0;
        }
        int len=0;
        long k=n;
        while(k!=0){
            len++;
            k=k/10;
        }
        long res=0;
        if(len>=4&&len<=6){
            return (long)1*(n-999);
        }else if(len>=7&&len<=9){
            return (long)(999999-999)+2*(n-999999);
        }else if(len>=10&&len<=12){
            return (long)(999999-999)+(999999999-999999)*2+3*(n-999999999);
        }else if(len>=13&&len<=15){
            return (long)(999999-999)+2*(999999999L-999999L)+3*(999999999999L-999999999L)+4*(n-999999999999L);
        }else{
            return (long)(999999-999)+2*(999999999L-999999)+3*(999999999999L-999999999L)+4*(999999999999999L-999999999999L)+5;
        }
    }
}