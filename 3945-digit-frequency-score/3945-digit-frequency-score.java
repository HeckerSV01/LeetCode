class Solution {
    public int digitFrequencyScore(int n) {
        int freq[]=new int[10];
        int k=n;
        while(k>0){
            int temp=k%10;
            freq[temp]++;
            k=k/10;
        }
        int res=0;
        for(int i=0;i<10;i++){
            res=res+i*freq[i];
        }
        return res;
    }
}