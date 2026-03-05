class Solution {
    public int minOperations(String s) {
        int way1=0;
        int way2=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='0'){
                    way1++;
                }
            }else{
                if(s.charAt(i)=='1'){
                    way1++;
                }
            }
        }
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='1'){
                    way2++;
                }
            }else{
                if(s.charAt(i)=='0'){
                    way2++;
                }
            }
        }
        return Math.min(way1,way2);
    }
}