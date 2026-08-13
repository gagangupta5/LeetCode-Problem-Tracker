//Solution 1: Using extra space
class Solution1 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] row=new boolean[m];
        boolean[] col=new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==true || col[j]==true){
                    matrix[i][j]=0;
                }
            }
        }
    }
}


//Solution 2: Without using extra space
class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean hasFirstRowZero=false;
        boolean hasFirstColZero=false;
        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                hasFirstRowZero=true;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                hasFirstColZero=true;
                break;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(hasFirstRowZero){
            for(int i=0;i<m;i++){
                matrix[0][i]=0;
            }
        }
        if(hasFirstColZero){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
}
