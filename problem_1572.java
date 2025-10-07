class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int res=0;
        int sr=0,sc=0,er=n-1,ec=n-1;
        while(sr<=er && sc<=ec){
            if(sr==er){
                res+=mat[sr][er];  //for middle element if n is odd
                break;
            }
            res+=mat[sr][sc]+mat[sr][ec]+mat[er][sc]+mat[er][ec];
            sr++;
            sc++;
            er--;
            ec--;
        }
        return res;
    }
}