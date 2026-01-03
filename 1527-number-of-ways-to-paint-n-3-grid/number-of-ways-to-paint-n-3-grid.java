class Solution {
    public int numOfWays(int n) {
        final int MOD = 1000000007;
        long alternating_patterns = 6, all_different_patterns = 6;
        
        for (int i = 2; i <= n; i++) {
            long new_alternating = (3 * alternating_patterns + 2 * all_different_patterns) % MOD;
            long new_all_different = (2 * alternating_patterns + 2 * all_different_patterns) % MOD;
            alternating_patterns = new_alternating;
            all_different_patterns = new_all_different;
        }
        
        return (int)((alternating_patterns + all_different_patterns) % MOD);
    }
}