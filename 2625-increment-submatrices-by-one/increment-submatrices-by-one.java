class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        
        // Apply difference array technique
        for (int[] query : queries) {
            int r1 = query[0], c1 = query[1], r2 = query[2], c2 = query[3];
            
            mat[r1][c1]++;
            if (c2 + 1 < n) mat[r1][c2 + 1]--;
            if (r2 + 1 < n) mat[r2 + 1][c1]--;
            if (r2 + 1 < n && c2 + 1 < n) mat[r2 + 1][c2 + 1]++;
        }
        
        // Calculate prefix sums row-wise
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }
        
        // Calculate prefix sums column-wise
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                mat[i][j] += mat[i - 1][j];
            }
        }
        
        return mat;
    }
}