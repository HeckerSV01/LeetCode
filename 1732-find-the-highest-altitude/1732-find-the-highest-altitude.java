class Solution {
    public int largestAltitude(int[] gain) {
        int pref=0;
        int max=0;
        for(int i=0;i<gain.length;i++){
            pref=pref+gain[i];
            max=Math.max(max,pref);
        }
        return max;
    }
}