class Solution {
    public int maxNumberOfBalloons(String text) {
        int freq[]=new int[26];
        for(int i=0;i<text.length();i++){
            freq[text.charAt(i)-'a']++;
        }
        int single=Math.min(freq['b'-'a'],Math.min(freq['a'-'a'],freq['n'-'a']));
        int doubl=Math.min(freq['l'-'a'],freq['o'-'a']);
        int words=(int)Math.floor(doubl/2);
        return Math.min(single,words);
    }
}