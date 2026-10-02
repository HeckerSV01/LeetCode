class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder("0");
        for(int i=2;i<=n;i++){
            StringBuilder temp=new StringBuilder();
            for(int j=0;j<sb.length();j++){
                if(sb.charAt(j)=='0'){
                    temp.append("1");
                }else{
                    temp.append("0");
                }
            }
            sb.append("1");
            sb.append(temp.reverse().toString());
        }
        return sb.charAt(k-1);
    }
}