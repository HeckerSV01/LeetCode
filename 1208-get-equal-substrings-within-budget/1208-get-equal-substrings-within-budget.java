class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l=0;
        int r=0;
        int cost=0;
        int res=-1;
        while(r<s.length()){
            cost=cost+Math.abs(s.charAt(r)-t.charAt(r));
            while(cost>maxCost){
                cost=cost-Math.abs(s.charAt(l)-t.charAt(l));
                l++;
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}