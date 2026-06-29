class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        int k=(numRows-1)*2;
        int temp=k;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numRows;i++){
            int j=i;
            boolean down=true;
            while(j<s.length()){
                sb.append(s.charAt(j));
                if(i==0||i==numRows-1){
                    j=j+k;
                }else{
                    if(down){
                        j=j+k-(2*i);
                    }else{
                        j=j+2*i;
                    }
                    down=!down;
                }
            }
        }
        return sb.toString();
    }
}