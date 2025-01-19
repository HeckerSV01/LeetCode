class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int k=0;
        int temp[]=new int[m+n];
        while(i<=m-1&&j<=n-1)
        {
            if(nums1[i]<nums2[j])
            {
                temp[k]=nums1[i];
                i++;
            }
            else
            {
                temp[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<=m-1)
        {
            temp[k++]=nums1[i++];
        }
        while(j<=n-1)
        {
            temp[k++]=nums2[j++];
        }
        int l=0;
        for(l=0,k=0;l<m+n;l++,k++)
        {
           nums1[l]=temp[k];
        }
    }
}