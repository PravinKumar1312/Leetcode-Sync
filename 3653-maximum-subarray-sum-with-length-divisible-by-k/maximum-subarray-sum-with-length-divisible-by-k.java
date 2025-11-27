class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        // Track minimum prefix sum for each modulo class
        long[] minPrefix = new long[k];
        // Initialize with a large value
        for (int i = 0; i < k; i++) {
            minPrefix[i] = Long.MAX_VALUE;
        }
        minPrefix[0] = 0; // prefixSum[0] = 0, and 0 % k = 0
        
        long maxSum = Long.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int mod = i % k;
            
            // If we have seen a prefix with the same modulo before
            if (minPrefix[mod] != Long.MAX_VALUE) {
                // The subarray sum would be prefixSum[i] - minPrefix[mod]
                // And the length would be i - j, where prefixSum[j] = minPrefix[mod]
                // Since both i and j have same modulo, (i - j) % k == 0
                long currentSum = prefixSum[i] - minPrefix[mod];
                maxSum = Math.max(maxSum, currentSum);
            }
            
            // Update the minimum prefix sum for current modulo
            minPrefix[mod] = Math.min(minPrefix[mod], prefixSum[i]);
        }
        
        return maxSum;
    }
}