class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Count how many numbers are <= mid
            int count = countLessEqual(matrix, mid);
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        
        // Start from bottom-left corner
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                // All elements in this column up to current row are <= target
                count += (row + 1);
                col++; // Move right
            } else {
                row--; // Move up
            }
        }
        
        return count;
    }
}