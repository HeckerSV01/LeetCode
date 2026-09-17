class Solution {
    public String getSmallestString(int n, int k) {
        char arr[]=new char[n];
        Arrays.fill(arr,'a');
        k=k-n;
        int idx=n-1;
        while(k>0){
            arr[idx]=(char)(arr[idx]+Math.min(k,25));
            k=k-Math.min(k,25);
            idx--;
        }
        return String.valueOf(arr);
    }
}