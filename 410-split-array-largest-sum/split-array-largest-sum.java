class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private boolean isFeasible(int[] nums, int k, int candidate) {
        int count = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > candidate) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}