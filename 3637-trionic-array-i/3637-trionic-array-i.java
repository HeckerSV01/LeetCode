class Solution {
    public boolean isTrionic(int[] nums) {
        if (nums.length == 3) {
            return false;
        }
        int i = 0;
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == nums.length - 1) {
            return false;
        }
        int j = i;
        while (j < nums.length - 1 && nums[j] > nums[j + 1]) {
            j++;
        }
        if (j == i || j == nums.length - 1) {
            return false;
        }
        int k = j;
        while (k < nums.length - 1 && nums[k] < nums[k + 1]) {
            k++;
        }
        return k == nums.length - 1;
    }
}