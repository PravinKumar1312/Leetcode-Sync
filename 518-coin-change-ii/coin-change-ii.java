class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] represents number of combinations to make amount i
        int[] dp = new int[amount + 1];
        
        // Base case: there's 1 way to make amount 0 (use no coins)
        dp[0] = 1;
        
        // Process each coin
        for (int coin : coins) {
            // For each amount from coin to target amount
            for (int i = coin; i <= amount; i++) {
                // Add the number of ways to make (current amount - coin value)
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}