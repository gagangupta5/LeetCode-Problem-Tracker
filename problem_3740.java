class Solution {
    public int minimumDistance(int[] nums) {
        int maxVal = 0;
        for (int x : nums) 
            maxVal = Math.max(maxVal, x);

        int[][] pos = new int[maxVal + 1][2];
        for (int[] row : pos) 
            Arrays.fill(row, -1);

        long res = 1L << 32;

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int last = pos[val][0];
            int secondLast = pos[val][1];

            if (secondLast != -1) {
                int distance = (i - secondLast) * 2;
                res = Math.min(res, (long) distance);
            }

            pos[val][1] = last;
            pos[val][0] = i;
        }

        return (res == (1L << 32)) ? -1 : (int) res;
    }
}