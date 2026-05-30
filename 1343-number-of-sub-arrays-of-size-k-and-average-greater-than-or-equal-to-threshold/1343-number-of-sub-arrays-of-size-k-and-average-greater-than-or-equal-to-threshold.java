class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0;
        int r=k-1;
        threshold=threshold*k;
        int count=0;
        int sum=0;
        for(int i=l;i<=r;i++){
            sum=sum+arr[i];
        }
        if(sum>=threshold){
            count++;
        }
        while(r<arr.length-1){
            sum=sum-arr[l];
            l++;
            r++;
            sum=sum+arr[r];
            if(sum>=threshold){
                count++;
            }
        }
        return count;
    }
}