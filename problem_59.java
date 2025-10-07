class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res=new int [n][n];
        int sr=0,sc=0,er=n-1,ec=n-1;
        int val=1;
        while(sr<=er && sc<=ec){
            //for top row insertion
            for(int i=sc;i<=ec;i++){
                res[sr][i]=val;
                val++;
            }
            //for right column insertion
            for(int i=sr+1;i<=er;i++){
                res[i][ec]=val;
                val++;
            }
            //for bottom row insertion
            for(int i=ec-1;i>=sc;i--){
                res[er][i]=val;
                val++;
            }
            //for left column insertion
            for(int i=er-1;i>sr;i--){
                res[i][sc]=val;
                val++;
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return res;
    }
}