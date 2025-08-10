class Solution {
    public String convertDateToBinary(String date) {
        int y=Integer.parseInt(date.substring(0,4));
        int m=Integer.parseInt(date.substring(5,7));
        int d=Integer.parseInt(date.substring(8,10));
        return Integer.toBinaryString(y)+"-"+Integer.toBinaryString(m)+"-"+Integer.toBinaryString(d);
    }
}