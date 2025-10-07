//Approach 1
class Solution1 {
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


//Approach 2
class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int res=0;
        for(int i=0;i<n;i++){
            //for primary diagonal
            res+=mat[i][i];
            //for secondary diagonal
            if(i!=n-i-1)
                res+=mat[i][n-i-1];
        }
        return res;
    }
}