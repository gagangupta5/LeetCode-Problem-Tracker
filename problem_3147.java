// S1: O(n*n/k) time
class Solution1 {
    int n;
    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int maxval = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int val = findEnergy(energy, k, i);
            maxval = Math.max(maxval, val);
        }
        return maxval;
    }

    // O(n/k) time
    private int findEnergy(int[] energy, int k, int i) {
        int val = energy[i];
        while(i + k < n) {
            i += k;
            val += energy[i];
        }
        return val;
    }
};


// S2: O(n*n/k) time
class Solution2 {
    int n;
    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int maxval = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            int val = findEnergy(energy, k, i);
            maxval = Math.max(maxval, val);
        }
        return maxval;
    }

    // O(n/k) time
    private int findEnergy(int[] energy, int k, int i) {
        int val = energy[i];
        if(i+k < n) val += findEnergy(energy, k, i+k);
        return val;
    }
};


// S3: Memoization O(n) time and space
class Solution3 {
    int n;

    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int maxval = Integer.MIN_VALUE;
        int[] tbl = new int[n];
        Arrays.fill(tbl, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int val = findEnergy(energy, k, i, tbl);
            maxval = Math.max(maxval, val);
        }
        return maxval;
    }

    // O(n/k) time
    private int findEnergy(int[] energy, int k, int i, int[] tbl) {
        if (tbl[i] != Integer.MIN_VALUE) return tbl[i];
        int val = energy[i];
        if (i + k < n) val += findEnergy(energy, k, i + k, tbl);
        return tbl[i] = val;
    }
}

// S4: DP Iterative O(n) time and space
class Solution4a {
    int n;

    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int maxval = Integer.MIN_VALUE;
        int[] tbl = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) tbl[i] = energy[i];
            else tbl[i] = energy[i] + tbl[i + k];
        }

        for (int i = 0; i < n; i++) {
            int val = tbl[i];
            maxval = Math.max(maxval, val);
        }
        return maxval;
    }
}

// S4b: DP Iterative O(n) time and space
class Solution4b {
    int n;

    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int maxval = Integer.MIN_VALUE;
        int[] tbl = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) tbl[i] = energy[i];
            else tbl[i] = energy[i] + tbl[i + k];
            maxval = Math.max(maxval, tbl[i]);
        }
        return maxval;
    }
}

// S4c: DP Iterative O(n) time and O(1) extra space
class Solution4c {
    int n;

    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int maxval = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) energy[i] = energy[i];
            else energy[i] = energy[i] + energy[i + k];
            maxval = Math.max(maxval, energy[i]);
        }
        return maxval;
    }
}

// S4d: DP Iterative O(n) time and O(1) extra space
class Solution {
    int n;

    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int maxval = Integer.MIN_VALUE;
        for (int j = 0; j < k; j++) {
            int i = n - 1 - j;
            int val = 0;
            while (i >= 0) {
                val += energy[i];
                maxval = Math.max(maxval, val);
                i -= k;
            }
        }
        return maxval;
    }
}
