class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int res = 0;
        int st = 0;
        int en = arr.length;
        while (st < en) {
            int mid = st + (en - st) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                res = mid;
                break;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        return res;
    }
}