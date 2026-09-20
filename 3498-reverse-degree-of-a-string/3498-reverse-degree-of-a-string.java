class Solution {
    public int reverseDegree(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            res=res+((26-(s.charAt(i)-'a'))*(i+1));
        }
        return res;
    }
}