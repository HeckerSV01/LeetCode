class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int temp[] = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            temp[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            temp[k++] = nums2[j++];
        }
        if (temp.length % 2 == 0) {
            return (double) (temp[(temp.length - 1) / 2] + temp[((temp.length - 1) / 2) + 1]) / 2;
        } else {
            return (double) temp[(temp.length - 1) / 2];
        }
    }
}