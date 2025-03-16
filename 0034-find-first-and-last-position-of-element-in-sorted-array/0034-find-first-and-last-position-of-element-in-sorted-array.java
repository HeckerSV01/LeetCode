class Solution {
    public int firstidx(int arr[],int k)
    {
        int st=0;
        int en=arr.length-1;
        int first=-1;
        while(st<=en)
        {
            int mid=st+(en-st)/2;
            if(arr[mid]==k)
            {
                first=mid;
                en=mid-1;
            }
            else if(arr[mid]<k)
            {
                st=mid+1;
            }
            else
            {
                en=mid-1;
            }
        }
        return first;
    }
    public int lastidx(int arr[],int k)
    {
        int st=0;
        int en=arr.length-1;
        int last=-1;
        while(st<=en)
        {
            int mid=st+(en-st)/2;
            if(arr[mid]==k)
            {
                last=mid;
                st=mid+1;
            }
            else if(arr[mid]<k)
            {
                st=mid+1;
            }
            else
            {
                en=mid-1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        ans[0]=firstidx(nums,target);
        ans[1]=lastidx(nums,target);
        return ans;
    }
}