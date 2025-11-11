class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] = maximum number of strings that can be formed with i zeros and j ones
        int[][] dp = new int[m + 1][n + 1];
        
        for (String str : strs) {
            // Count zeros and ones in current string
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            
            // Process in reverse to avoid reusing the same string
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
}