class Solution {
    public void mergesort(int nums[],int st,int en)
    {
        if(st>=en)
        {
            return;
        }
        int mid=st+(en-st)/2;
        mergesort(nums,st,mid);
        mergesort(nums,mid+1,en);
        merger(nums,st,en,mid);
    }
    public void merger(int nums[],int st,int en,int mid)
    {
        int i=0;
        int j=0;
        int k=st;
        int leftarr[]=Arrays.copyOfRange(nums,st,mid+1);
        int rightarr[]=Arrays.copyOfRange(nums,mid+1,en+1);
        while(i<leftarr.length&&j<rightarr.length)
        {
            if(leftarr[i]<=rightarr[j])
            {
                nums[k]=leftarr[i];
                i++;
            }
            else
            {
                nums[k]=rightarr[j];
                j++;
            }
            k++;
        }
        while(i<leftarr.length)
        {
            nums[k++]=leftarr[i++];
        }
        while(j<rightarr.length)
        {
            nums[k++]=rightarr[j++];
        }
    }
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
}