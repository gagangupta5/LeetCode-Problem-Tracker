//Solution 1: Brute Force
class Solution1 {
    public int rob(int[] nums) {
        int n=nums.length;
        int s1=0,s2=0;
        for(int i=0;i<n;i++){
            int x=Math.max(s1,s2+nums[i]);
            s2=s1;
            s1=x;
        }
        return s1;
    }
}

//Solution 2: Using Memoization
class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        java.util.Arrays.fill(memo, -1);
        return solve(nums, 0, memo);
    }

    private int solve(int[] nums, int i, int[] memo) {
        int n = nums.length;
        if (i >= n) return 0;
        if (memo[i] != -1) return memo[i];
        int curr = nums[i] + solve(nums, i + 2, memo);
        int skip = solve(nums, i + 1, memo);
        return memo[i] = Math.max(curr, skip);
    }
}
