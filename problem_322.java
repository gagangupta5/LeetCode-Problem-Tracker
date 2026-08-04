// Recursive Solution
class Solution1 {
    private int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        return solve(coins, amount);
    }
    private int solve(int[] coins, int rem) {
        if (rem < 0) {
            return -1;
        }
        if (dp[rem] != Integer.MAX_VALUE) {
            return dp[rem];
        }
        int minCost = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, rem - coin);
            if (res >= 0 && res < minCost) {
                minCost = res + 1;
            }
        }
        dp[rem] = (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        return dp[rem];
    }
}


// Iterative Solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        if(amount<0) return -1;
        if(amount==0) return 0;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int i=1;i<=amount;i++) dp[0][i]=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    if (dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}
