class Solution {
    public boolean check(int a[],int l,int r)
    {
        int arr[]=new int[r-l+1];
        int k=0;
        for(int i=l;i<=r;i++)
        {
            arr[k++]=a[i];
        }
        Arrays.sort(arr);
        for(int i=2;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1]!=arr[1]-arr[0])
            {
                return false;
            }
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res=new ArrayList<>(); 
        for(int i=0;i<l.length;i++)
        {
            res.add(check(nums,l[i],r[i]));
        }
        return res;
    }
}