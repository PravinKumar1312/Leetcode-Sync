class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Count number of 1s
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            }
        }
        
        // If there's at least one 1, we can spread it
        if (countOnes > 0) {
            return n - countOnes;
        }
        
        // Find the minimum length subarray with gcd = 1
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int currentGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        
        if (minLen == Integer.MAX_VALUE) {
            return -1;
        }
        
        // Operations to create first 1: (minLen - 1)
        // Operations to convert remaining elements: (n - 1)
        return (minLen - 1) + (n - 1);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}