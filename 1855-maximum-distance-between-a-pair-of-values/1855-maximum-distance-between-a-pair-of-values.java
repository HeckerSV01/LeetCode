class Solution {
    private int bs(int a[],int i1,int i2,int key){
        int f=i1;
        int l=i2;
        while(f<=l){
            int mid=f+(l-f)/2;
            if(a[mid]>=key){
                f=mid+1;
            }else{
                l=mid-1;
            }
        }
        return l;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        for(int i=0;i<nums1.length;i++){
            int idx=bs(nums2,i,nums2.length-1,nums1[i]);
            max=Math.max(max,idx-i);
        }
        return max;
    }
}