class Solution {
    public double maxAmount(String init, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2,
            double[] rates2) {
        HashMap<String, HashMap<String, Double>> adj1 = new HashMap<>();
        HashMap<String, HashMap<String, Double>> adj2 = new HashMap<>();
        for (int i = 0; i < pairs1.size(); i++) {
            String s1 = pairs1.get(i).get(0);
            String s2 = pairs1.get(i).get(1);
            if (!adj1.containsKey(s1)) {
                adj1.put(s1, new HashMap<>());
            }
            adj1.get(s1).put(s2, rates1[i]);
            if (!adj1.containsKey(s2)) {
                adj1.put(s2, new HashMap<>());
            }
            adj1.get(s2).put(s1, (double) 1 / rates1[i]);
        }
        for (int i = 0; i < pairs2.size(); i++) {
            String s1 = pairs2.get(i).get(0);
            String s2 = pairs2.get(i).get(1);
            if (!adj2.containsKey(s1)) {
                adj2.put(s1, new HashMap<>());
            }
            adj2.get(s1).put(s2, rates2[i]);
            if (!adj2.containsKey(s2)) {
                adj2.put(s2, new HashMap<>());
            }
            adj2.get(s2).put(s1, (double) 1 / rates2[i]);
        }
        HashMap<String, Double> maxval1 = new HashMap<>();
        maxval1.put(init, 1.0);
        Queue<String> q1 = new LinkedList<>();
        q1.add(init);
        while (!q1.isEmpty()) {
            String cur = q1.remove();
            double curval = maxval1.get(cur);
            HashMap<String, Double> map = adj1.get(cur);
            for (String s : map.keySet()) {
                String nxt = s;
                double rate = map.get(s);
                double newval = curval * rate;
                if (newval > maxval1.getOrDefault(nxt, 0.0)) {
                    maxval1.put(nxt, newval);
                    q1.add(nxt);
                }
            }
        }
        HashMap<String, Double> maxval2 = new HashMap<>(maxval1);
        Queue<String> q2 = new LinkedList<>(maxval1.keySet());
        while (!q2.isEmpty()) {
            String cur = q2.remove();
            double curval = maxval2.get(cur);
            if (!adj2.containsKey(cur)) {
                continue;
            }
            HashMap<String, Double> map = adj2.get(cur);
            for (String s : map.keySet()) {
                String nxt = s;
                double rate = map.get(s);
                double newval = curval * rate;
                if (newval > maxval2.getOrDefault(nxt, 0.0)) {
                    maxval2.put(nxt, newval);
                    q2.add(nxt);
                }
            }
        }
        return maxval2.getOrDefault(init, 0.0);
    }
}