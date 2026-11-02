class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo=new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(solve(cost, 0, memo), solve(cost, 1, memo));
    }
    private int solve(int[] cost, int index, int[] memo){
        if(index>=cost.length) return 0;
        if(memo[index]!=-1) return memo[index];
        int take=solve(cost, index+1, memo);
        int skip=solve(cost, index+2, memo);
        memo[index]=cost[index]+Math.min(take, skip);
        return memo[index];
    }
}
