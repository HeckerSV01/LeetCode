class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int k=i;
            boolean valid=true;
            boolean mirror=false;
            while(k>0){
                int num=k%10;
                if(num==2||num==5||num==6||num==9){
                    mirror=true;
                }else if(num==0||num==1||num==8){
                    valid=true;
                }else{
                    valid=false;
                    break;
                }
                k=k/10;
            }
            if(valid&&mirror){
                count++;
            }
        }
        return count;
    }
}