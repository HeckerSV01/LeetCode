class Solution {
    public int reinitializePermutation(int n) {
        int count=0;
        int init[]=new int[n];
        int a1[]=new int[n];
        for(int i=0;i<n;i++){
            a1[i]=i;
            init[i]=i;
        }    
        while(true){
            int a2[]=new int [n];
            for(int i=0;i<n;i++){
                if(i%2==0){
                    a2[i]=a1[i/2];
                }else{
                    a2[i]=a1[n/2+(i-1)/2];
                }
            }
            count++;
            if (Arrays.equals(a2, init)) {
                break;
            }
            a1=a2;
        }
        return count; 
    }
}