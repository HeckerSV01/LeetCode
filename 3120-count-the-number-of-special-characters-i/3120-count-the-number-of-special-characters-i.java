class Solution {
    public int numberOfSpecialChars(String word) {
        int a[]=new int[123];
        for(int i=0;i<word.length();i++){
            a[(int)word.charAt(i)]++;
        }
        int count=0;
        for(int i=65;i<=90;i++){
            if(a[i]>0&&a[i+32]>0){
                count++;
            }
        }
        return count;
    }
}