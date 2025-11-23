class Solution {
    public int maxSumDivThree(int[] nums) {
        // dp[0], dp[1], dp[2] represent max sum with remainder 0, 1, 2
        int[] dp = new int[3];
        
        for (int num : nums) {
            // Make a copy of current dp state
            int[] next = dp.clone();
            
            for (int remainder = 0; remainder < 3; remainder++) {
                if (dp[remainder] != 0 || remainder == 0) {
                    int newRemainder = (remainder + num) % 3;
                    next[newRemainder] = Math.max(next[newRemainder], dp[remainder] + num);
                }
            }
            
            dp = next;
        }
        
        return dp[0];
    }
}