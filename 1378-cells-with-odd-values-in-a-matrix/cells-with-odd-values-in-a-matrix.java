class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // Arrays to track how many times each row and column is incremented
        int[] rowIncrements = new int[m];
        int[] colIncrements = new int[n];
        
        // Count increments for each row and column
        for (int[] index : indices) {
            int ri = index[0];
            int ci = index[1];
            rowIncrements[ri]++;
            colIncrements[ci]++;
        }
        
        // Count how many rows have odd increments
        int oddRows = 0;
        for (int count : rowIncrements) {
            if (count % 2 == 1) {
                oddRows++;
            }
        }
        
        // Count how many columns have odd increments
        int oddCols = 0;
        for (int count : colIncrements) {
            if (count % 2 == 1) {
                oddCols++;
            }
        }
        
        // Calculate number of odd cells
        // oddRows × (n - oddCols): rows with odd increments paired with columns with even increments
        // (m - oddRows) × oddCols: rows with even increments paired with columns with odd increments
        return oddRows * (n - oddCols) + (m - oddRows) * oddCols;
    }
}