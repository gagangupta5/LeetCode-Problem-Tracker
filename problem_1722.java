class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] p = new int[n];
        
        // Every index starts as its own leader
        for (int i = 0; i < n; i++) p[i] = i;
        
        // Group connected indices together
        for (int[] sw : allowedSwaps) {
            union(p, sw[0], sw[1]);
        }
        
        // Map to hold our groups of indices based on their root leader
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = find(p, i);
            g.computeIfAbsent(r, k -> new ArrayList<>()).add(i);
        }
        
        int match = 0;
        
        // Process each group one by one
        for (List<Integer> list : g.values()) {
            List<Integer> s = new ArrayList<>();
            List<Integer> t = new ArrayList<>();
            
            // Collect the actual numbers for this group
            for (int i : list) {
                s.add(source[i]);
                t.add(target[i]);
            }
            
            // Sort to easily find matches
            Collections.sort(s);
            Collections.sort(t);
            
            // Two pointers to count how many numbers overlap
            int i = 0, j = 0;
            while (i < s.size() && j < t.size()) {
                int a = s.get(i), b = t.get(j);
                if (a == b) {
                    match++;
                    i++;
                    j++;
                } else if (a < b) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        
        // Hamming distance is total length minus the matches we found
        return n - match;
    }
    
    // Union-Find: Find the root leader
    private int find(int[] p, int i) {
        if (p[i] == i) return i;
        return p[i] = find(p, p[i]);
    }
    
    // Union-Find: Connect two indices
    private void union(int[] p, int u, int v) {
        int r1 = find(p, u), r2 = find(p, v);
        if (r1 != r2) p[r1] = r2;
    }
}