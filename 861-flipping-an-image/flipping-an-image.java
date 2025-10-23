class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        
        for (int i = 0; i < n; i++) {
            // Reverse the row
            for (int j = 0; j < n / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][n - 1 - j];
                image[i][n - 1 - j] = temp;
            }
            
            // Invert using XOR with 1
            for (int j = 0; j < n; j++) {
                image[i][j] ^= 1;
            }
        }
        
        return image;
    }
}