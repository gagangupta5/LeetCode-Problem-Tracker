class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;
        int c = 1;
        while (c <= 4) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < m; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
            int i = 0, j = m - 1;
            while (i < j) {
                for (int k = 0; k < n; k++) {
                    int temp = mat[k][i];
                    mat[k][i] = mat[k][j];
                    mat[k][j] = temp;
                }
                i++;
                j--;
            }
            c++;
            if (Arrays.deepEquals(mat, target))
                return true;
        }
        return false;
    }
}