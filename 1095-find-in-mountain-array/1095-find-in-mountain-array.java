/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakidx = 0;
        int st = 0;
        int en = mountainArr.length() - 1;
        int temp = en;
        while (st < en) {
            int mid = st + (en - st) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        peakidx = st;
        if (mountainArr.get(peakidx) == target) {
            return peakidx;
        }
        st = 0;
        en = peakidx - 1;
        int res = -1;
        while (st <= en) {
            int mid = st + (en - st) / 2;
            int midval = mountainArr.get(mid);
            if (target == midval) {
                res = mid;
                break;
            } else if (target > midval) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }
        st = peakidx + 1;
        en = temp;
        while (st <= en) {
            int mid = st + (en - st) / 2;
            int midval = mountainArr.get(mid);
            if (target == midval) {
                if (res == -1) {
                    res = mid;
                } else {
                    res = Math.min(res, mid);
                }
                break;
            } else if (target > midval) {
                en = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return res;
    }
}