class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int k=0;
        int res[]=new int[s.length()];
        for(int a=0;a<s.length();a++){
            int i=startPos[0];
            int j=startPos[1];
            int count=0;
            for(int b=a;b<s.length();b++){
                char c=s.charAt(b);
                if(c=='U'){
                    i--;
                }else if(c=='D'){
                    i++;
                }else if(c=='R'){
                    j++;
                }else{
                    j--;
                }
                if(i<0||i>=n||j<0||j>=n){
                    break;
                }
                count++;
            }
            res[k++]=count;
        }
        return res;
    }
}