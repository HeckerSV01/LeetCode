class Solution {
    private void dfs(int a[], HashMap<Integer, Integer> sizes, HashMap<Integer, List<Integer>> map, int node) {
        int size = 0;
        for (int k : map.get(node)) {
            dfs(a, sizes, map, k);
            size = size + sizes.get(k);
        }
        sizes.put(node, size + 1);
    }

    private int score(HashMap<Integer, Integer> sizes, HashMap<Integer, List<Integer>> map, int n) {
        long maxScore = 0;
        int count = 0;
        for (int node = 0; node < n; node++) {
            long score = 1;
            for (int child : map.get(node)) {
                score *= sizes.get(child);
            }
            int remaining = n - sizes.get(node);
            if (remaining > 0) {
                score *= remaining;
            }

            if (score > maxScore) {
                maxScore = score;
                count = 1;
            } else if (score == maxScore) {
                count++;
            }
        }
        return count;
    }

    public int countHighestScoreNodes(int[] parents) {
        HashMap<Integer, Integer> sizes = new HashMap<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = parents.length;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            map.get(parents[i]).add(i);
        }
        dfs(parents, sizes, map, 0);
        return score(sizes, map, n);
    }
}