class Solution {
    private int fact(int n) {
        int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        if (n >= 0 && n <= 9) {
            return factorials[n];
        }
        return 0;
    }
    public boolean isDigitorialPermutation(int n) {
        String s=String.valueOf(n);
        char a[]=s.toCharArray();
        int sum=0;
        for(char c:a){
            sum=sum+fact(c-'0');
        }
        String s2=String.valueOf(sum);
        int a1[]=new int[10];
        int a2[]=new int[10];
        for(char c:s.toCharArray()){
            a1[c-'0']++;
        }
        for(char c:s2.toCharArray()){
            a2[c-'0']++;
        }
        for(int i=0;i<a1.length;i++){
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }
}