class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][]dp=new int[m][n][k+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int l=0;l<=k;l++){
                    dp[i][j][l]=-1;
                }
            }
        }
        dp[0][0][0]=0;
        int score=-1;
        for(int i=1;i<m;i++){
            int cost=(grid[i][0]==0?0:1);
            for(int c=0;c+cost<=k;c++){
                if(dp[i-1][0][c]!=-1){
                dp[i][0][c+cost]=Math.max(dp[i][0][c+cost],dp[i-1][0][c]+grid[i][0]);
                }
            }
        }
        for(int j=1;j<n;j++){
            int cost=(grid[0][j]==0?0:1);
            for(int c=0;c+cost<=k;c++){
                if(dp[0][j-1][c]!=-1){
                dp[0][j][c+cost]=Math.max(dp[0][j][c+cost],dp[0][j-1][c]+grid[0][j]);
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int cost=(grid[i][j]==0?0:1);
                for(int c=0;c+cost<=k;c++){
                    if(dp[i-1][j][c]!=-1){
                        dp[i][j][c+cost]=Math.max(dp[i][j][c+cost],dp[i-1][j][c]+grid[i][j]);
                    }
                    if(dp[i][j-1][c]!=-1){
                        dp[i][j][c+cost]=Math.max(dp[i][j][c+cost],dp[i][j-1][c]+grid[i][j]);
                    }
                }
            }
        }
        for(int c=0;c<=k;c++){
            score=Math.max(score,dp[m-1][n-1][c]);
        }
        return score;
    }
}