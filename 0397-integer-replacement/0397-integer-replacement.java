class Solution {
    private int cal(long n, HashMap<Long, Integer> dp) {
        if (n == 1) {
            return 0;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int op1 = Integer.MAX_VALUE;
        int op2 = Integer.MAX_VALUE;
        int op3 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            op1 = 1 + cal(n / 2, dp);
        } else {
            op2 = 1 + cal(n + 1, dp);
            op3 = 1 + cal(n - 1, dp);
        }
        int res = Math.min(op1, Math.min(op2, op3));
        dp.put(n, res);
        return res;
    }

    public int integerReplacement(int n) {
        HashMap<Long, Integer> dp = new HashMap<>();
        return cal((long) n, dp);
    }
}