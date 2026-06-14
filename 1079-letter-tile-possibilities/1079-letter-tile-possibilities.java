class Solution {
    int count=0;
    private void backtrack(String tiles,int i,int freq[]){
        for(int j=0;j<26;j++){
            if(freq[j]>0){
                count++;
                freq[j]--;
                backtrack(tiles,i+1,freq);
                freq[j]++;
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        int freq[]=new int[26];
        for(int i=0;i<tiles.length();i++){
            freq[tiles.charAt(i)-'A']++;
        }
        backtrack(tiles,0,freq);
        return count;
    }
}