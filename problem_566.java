class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n=mat.length,m=mat[0].length;
        if((r*c)!=(n*m)) return mat;
        if(r==n && c==m) return mat;
        int[][] res=new int[r][c];
        int a=0,b=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[a][b]=mat[i][j];
                b++;
                if(b==c){
                    b=0;
                    a++;
                }
            }
        }
        return res;
    }
}