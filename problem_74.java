//Approach 1 
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        int l=0,h=n-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(matrix[mid][0]>target) h=mid-1;
            else if(matrix[mid][m-1]<target) l=mid+1;
            else{
                int l1=0,h1=m-1;
                while(l1<=h1){
                    int mid1=(l1+h1)/2;
                    if(matrix[mid][mid1]==target) return true;
                    else if(matrix[mid][mid1]<target) l1=mid1+1;
                    else h1=mid1-1;
                }
                return false;
            }
        }
        return false;
    }
}


//Approach 2 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int i=m-1,j=0;
        while(i>=0 && j<n){
            if(matrix[i][j]==target) return true;
            if(matrix[i][j]>target) i--;
            else j++;
        }
        return false;
    }
}