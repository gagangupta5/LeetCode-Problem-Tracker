class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int res=0;
        int[][] x=new int[n+1][m+1];
        int[][] y=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                x[i+1][j+1]=(grid[i][j]=='X'?1:0)+x[i+1][j]+x[i][j+1]-x[i][j];
                y[i+1][j+1]=(grid[i][j]=='Y'?1:0)+y[i+1][j]+y[i][j+1]-y[i][j];
                if(x[i+1][j+1]>0 && x[i+1][j+1]==y[i+1][j+1]) res++;
            }
        }
        return res;
    }
}