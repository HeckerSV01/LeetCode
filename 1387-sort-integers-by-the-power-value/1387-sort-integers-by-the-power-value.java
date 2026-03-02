class Solution {
    private int solve(int num, HashMap<Integer, Integer> dp) {
        int temp = num;
        if (temp == 1) {
            return 1;
        }
        if (temp < 0) {
            return 0;
        }
        if (dp.get(num) != null) {
            return dp.get(num);
        }
        int steps = 0;
        if (temp % 2 == 0) {
            steps = 1 + solve(temp / 2, dp);
        } else {
            steps = 1 + solve(3 * temp + 1, dp);
        }
        dp.put(num, steps);
        return steps;
    }

    public int getKth(int lo, int hi, int k) {
        int len = hi - lo + 1;
        HashMap<Integer, Integer> dp = new HashMap<>();
        int arr[][] = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = lo;
            arr[i][1] = solve(lo, dp);
            lo++;
        }
        Arrays.sort(arr, (x, y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        });
        return arr[k - 1][0];
    }
}