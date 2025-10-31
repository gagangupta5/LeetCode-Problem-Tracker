class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        //for lower diagonals
        for(int i=n-1;i>=0;i--){
            int k=i,j=0;
            while(k<n-1 && j<m-1){
                if(matrix[k][j]!=matrix[k+1][j+1]) return false;
                j++;
                k++;
            }
        }

        //for upper diagonals
        for(int j=1;j<m-1;j++){
            int k=j,i=0;
             while(i<n-1 && k<m-1){
                if(matrix[i][k]!=matrix[i+1][k+1]) return false;
                i++;
                k++;
            }
        }
        return true;
    }
}