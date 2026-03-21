class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int i=x,j=y,l=x+k-1;
        while(i<l){
            j=y;
            while(j<y+k){
                int temp=grid[i][j];
                grid[i][j]=grid[l][j];
                grid[l][j]=temp;
                j++;
            }
            i++;
            l--;
        }
        return grid;
    }
}