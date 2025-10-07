class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        List<Integer> res=new ArrayList<>();
        int sr=0,sc=0,er=m-1,ec=n-1;
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++) res.add(matrix[sr][i]);  //for top row
            for(int i=sr+1;i<=er;i++) res.add(matrix[i][ec]);  //for right column
            for(int i=ec-1;i>=sc;i--){
                if(sr==er) break;
                res.add(matrix[er][i]);  //for bottom row
            }
            for(int i=er-1;i>sr;i--){
                if(sc==ec) break;
                res.add(matrix[i][sc]);  //for left column
            } 
            sr++;
            sc++;
            er--;
            ec--;
        }
        return res;
    }
}