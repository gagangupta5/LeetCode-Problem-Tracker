class Solution {
    double[][] dp;
    double tot;
    public double func(int i, int j) {
        if(j < 0 || j > i) return 0.0;
        if(i == 0) return tot;
        if(dp[i][j] != -1.0) return dp[i][j];
        double l = func(i-1, j-1);
        double r = func(i-1, j);
        double ans = 0.0;
        if(l >= 1.0)
        ans+= (l-1.0)/2.0 ;
        if(r >= 1.0)
        ans+= (r-1.0)/2.0 ;
        dp[i][j] = ans;
        return ans;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
         dp = new double[query_row+1][query_row+1];
         for(double[] a : dp) {
            Arrays.fill(a, -1.0);
         }
         tot = (double)poured;
         double ans = func(query_row, query_glass);
         
         return Math.min(1.0, ans);
    }
}