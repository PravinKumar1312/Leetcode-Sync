import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // queens[i] = column position of queen in row i
        backtrack(result, queens, 0, n);
        return result;
    }
    
    private void backtrack(List<List<String>> result, int[] queens, int row, int n) {
        if (row == n) {
            // All queens are placed, construct the solution
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (queens[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                backtrack(result, queens, row + 1, n);
                // backtrack: no need to remove because we overwrite in next iteration
            }
        }
    }
    
    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int otherCol = queens[i];
            // Check same column or diagonals
            if (otherCol == col || Math.abs(row - i) == Math.abs(col - otherCol)) {
                return false;
            }
        }
        return true;
    }
}