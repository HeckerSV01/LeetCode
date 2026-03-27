class Solution {
    private int[] calculate(int a[]){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i];
            max=Math.max(max,a[i]);
        }
        return new int[]{sum,max};
    }
    private int students(int a[],int limit){
        int res=1;
        int sum=0;
        for(int i=0;i<a.length;i++){
            if(sum+a[i]<=limit){
                sum=sum+a[i];
            }else{
                sum=a[i];
                res++;
            }
        }
        return res;
    }
    public int splitArray(int[] nums, int k) {
        int arr[]=calculate(nums);
        int low=arr[1];
        int high=arr[0];
        int res=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            int temp=students(nums,mid);
            if(temp>k){
                low=mid+1;
            }else{
                res=Math.min(res,mid);
                high=mid-1;
            }
        }
        return res;
    }
}