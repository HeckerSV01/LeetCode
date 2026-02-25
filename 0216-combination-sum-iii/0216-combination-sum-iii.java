class Solution {
    List<List<Integer>> res = new ArrayList<>();

    private void backtrack(int i, int k, int n, List<Integer> list) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i + 1; j <= 9; j++) {
            list.add(j);
            backtrack(j, k - 1, n - j, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(0, k, n, new ArrayList<>());
        return res;
    }
}