class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 0 = unoccupied & unguarded, 1 = guard, 2 = wall, 3 = guarded
        int[][] grid = new int[m][n];
        
        // Mark guards
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        
        // Mark walls
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        
        // Directions: up, right, down, left
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // For each guard, mark all visible cells
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            
            // Check all 4 directions
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                
                // Keep going in this direction until we hit a wall, guard, or boundary
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    // Mark this cell as guarded (use 3 to represent guarded cells)
                    grid[r][c] = 3;
                    
                    // Move to next cell in this direction
                    r += dir[0];
                    c += dir[1];
                }
            }
        }
        
        // Count unoccupied and unguarded cells (cells with value 0)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}