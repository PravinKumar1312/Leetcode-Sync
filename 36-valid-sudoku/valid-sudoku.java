class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initialize arrays for rows, columns, and boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '1'; // Convert to index (0-8)
                int boxIndex = (i / 3) * 3 + (j / 3);
                
                // Check if the number has been seen in the current row, column, or box
                if (rows[i][num] || columns[j][num] || boxes[boxIndex][num]) {
                    return false;
                }
                
                // Mark the number as seen
                rows[i][num] = true;
                columns[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}