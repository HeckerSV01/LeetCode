class Solution {
    private boolean cal(int a[], int i, int prevjumpsize, HashMap<Integer, Integer> map, Boolean dp[][]) {
        if (i == a.length - 1) {
            return true;
        }
        if (dp[i][prevjumpsize] != null) {
            return dp[i][prevjumpsize];
        }
        boolean way1 = false;
        boolean way2 = false;
        boolean way3 = false;
        if (map.containsKey(a[i] + prevjumpsize)) {
            way1 = way1 || cal(a, map.get(a[i] + prevjumpsize), prevjumpsize, map, dp);
        }
        if (map.containsKey(a[i] + prevjumpsize + 1)) {
            way2 = way2 || cal(a, map.get(a[i] + prevjumpsize + 1), prevjumpsize + 1, map, dp);
        }
        if (prevjumpsize - 1 > 0 && map.containsKey(a[i] + prevjumpsize - 1)) {
            way3 = way3 || cal(a, map.get(a[i] + prevjumpsize - 1), prevjumpsize - 1, map, dp);
        }
        return dp[i][prevjumpsize] = way1 || way2 || way3;
    }

    public boolean canCross(int[] stones) {
        if (stones[1] - stones[0] > 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        Boolean dp[][] = new Boolean[stones.length][stones.length];
        return cal(stones, 1, 1, map, dp);
    }
}