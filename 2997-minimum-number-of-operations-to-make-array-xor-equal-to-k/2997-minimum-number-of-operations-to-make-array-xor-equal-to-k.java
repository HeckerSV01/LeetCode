class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        int diff = xor ^ k; 
        int res = 0;

        while (diff > 0) {
            res += (diff & 1); 
            diff >>= 1;       
        }

        return res;
    }
}