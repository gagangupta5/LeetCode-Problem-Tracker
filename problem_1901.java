class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int l=0,r=m-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int max_row=0;
            for(int i=0;i<n;i++){
                if(mat[i][mid]>mat[max_row][mid]){
                    max_row=i;
                }
            }
            boolean leftMax=mid>0 && mat[max_row][mid-1]>mat[max_row][mid];
            boolean rightMax=mid<m-1 && mat[max_row][mid+1]>mat[max_row][mid];
            if(!leftMax && !rightMax){
                return new int[]{max_row,mid};
            }
            else if(rightMax) l=mid+1;
            else r=mid-1;
        }
        return new int[]{-1,-1};
    }
}