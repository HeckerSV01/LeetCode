class Solution {
    public int[] divcount(int num) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    count++;
                    sum = sum + i;
                }
                else {
                    count = count + 2;
                    sum = sum + i + (num / i);
                }
            }
        }
        return new int[] { count, sum };
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int k : nums) {
            int a[] = divcount(k);
            if (a[0] == 4) {
                res = res + a[1];
            }
        }
        return res;
    }
}