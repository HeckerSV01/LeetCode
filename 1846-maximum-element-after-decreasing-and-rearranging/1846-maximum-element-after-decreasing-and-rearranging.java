class Solution {
    private int max(int arr[]){
        int res=0;
        for(int i=0;i<arr.length;i++){
            res=Math.max(res,arr[i]);
        }
        return res;
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]!=1){
            arr[0]=1;
        }
        boolean check=true;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]>1){
                check=false;
                break;
            }
        }
        if(check){
            return max(arr);
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
            }
        }
        return max(arr);
    }
}