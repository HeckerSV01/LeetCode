class Solution {
    //private boolean[] check(int freq1[],int freq2[],String s,String t){
    //    boolean excess=false;
    //    for(char c:t.toCharArray()){
    //        if(freq1[c-'A']<freq2[c-'A']){
    //            excess=true;
    //        }
    //        if(freq1[c-'A']>freq2[c-'A']){
    //            return new boolean[]{false,false};
    //        }
    //    }
    //    if(excess){
    //        return new boolean[]{true,true};
    //    }else{
    //        return new boolean[]{true,false};
    //    }
    //}
    public String minWindow(String s, String t) {
        int freq1[] = new int[58];
        int freq2[] = new int[58];
        int minlen = Integer.MAX_VALUE;
        String res = "";
        for (char c : t.toCharArray()) {
            freq1[c - 'A']++;
        }
        int l = 0;
        int r = 0;
        int req = t.length();
        while (r < s.length()) {
            freq2[s.charAt(r) - 'A']++;
            if (freq1[s.charAt(r) - 'A'] > 0 && freq1[s.charAt(r) - 'A'] >= freq2[s.charAt(r) - 'A']) {
                req--;
            }
            while (req == 0) {
                freq2[s.charAt(l) - 'A']--;
                if (freq1[s.charAt(l) - 'A'] > 0 && freq1[s.charAt(l) - 'A'] > freq2[s.charAt(l) - 'A']) {
                    req++;
                }
                if (r - l + 1 < minlen) {
                        minlen = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                l++;
            }
            r++;
        }
        return res;
    }
}