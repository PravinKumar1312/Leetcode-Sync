class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // since 0 <= nums[i] <= 100
        
        // Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }
        
        // Calculate running sum (count of numbers <= current number)
        int runningSum = 0;
        int[] smallerCount = new int[101];
        for (int i = 0; i <= 100; i++) {
            smallerCount[i] = runningSum;
            runningSum += count[i];
        }
        
        // Build result
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = smallerCount[nums[i]];
        }
        
        return result;
    }
}