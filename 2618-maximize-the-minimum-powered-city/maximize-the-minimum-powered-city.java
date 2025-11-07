class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        
        // Step 1: Calculate initial power for each city using prefix sums
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }
        
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }
        
        // Step 2: Binary search on the answer
        long left = 0;
        long right = 0;
        
        // Find the maximum possible upper bound
        for (long p : power) {
            right = Math.max(right, p);
        }
        right += k;
        
        long answer = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canAchieve(power, r, k, mid, n)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canAchieve(long[] power, int r, int k, long target, int n) {
        // Difference array to track added stations' effect
        long[] add = new long[n + 1];
        long currAdd = 0;
        long stationsUsed = 0;
        
        for (int i = 0; i < n; i++) {
            // Add the effect of stations placed earlier
            currAdd += add[i];
            long currentPower = power[i] + currAdd;
            
            if (currentPower < target) {
                long needed = target - currentPower;
                stationsUsed += needed;
                
                if (stationsUsed > k) {
                    return false;
                }
                
                // Place stations at the farthest position that can help city i
                int pos = Math.min(n - 1, i + r);
                currAdd += needed;
                
                // Mark where the effect of these stations ends
                if (pos + r + 1 < n) {
                    add[pos + r + 1] -= needed;
                }
            }
        }
        
        return stationsUsed <= k;
    }
}