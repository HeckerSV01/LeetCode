class Element { 
    char val; 
    int freq; 
    
    public Element(char val, int freq) { 
        this.val = val; 
        this.freq = freq; 
    } 
}

class Solution { 
    public String frequencySort(String s) {
        // Use a map to support all characters (uppercase, symbols, etc.)
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        // Max-heap: Sort by frequency in descending order (b.freq - a.freq)
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            pq.offer(new Element(entry.getKey(), entry.getValue()));
        }
        
        // Build the final string
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Element e = pq.poll();
            sb.append(String.valueOf(e.val).repeat(e.freq));
        }
        
        return sb.toString();
    } 
}