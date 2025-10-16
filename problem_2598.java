class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each remainder
        for (int num : nums) {
            int r = ((num % value) + value) % value; // handle negatives
            freq.put(r, freq.getOrDefault(r, 0) + 1);
        }

        // Step 2: Find smallest missing number
        int x = 0;
        while (true) {
            int r = x % value;
            if (!freq.containsKey(r) || freq.get(r) == 0) {
                return x;  // smallest missing found
            }
            freq.put(r, freq.get(r) - 1); // use one occurrence
            x++;
        }
    }
}