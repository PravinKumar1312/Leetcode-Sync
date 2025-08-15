class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        
        int lessCount = 0;
        for (int num : nums) {
            if (num < pivot) {
                lessCount++;
            }
        }
        
        int equalCount = 0;
        for (int num : nums) {
            if (num == pivot) {
                equalCount++;
            }
        }
        
        int greaterPos = lessCount + equalCount;
        int lessPos = 0;
        int equalPos = lessCount;
        
        for (int num : nums) {
            if (num < pivot) {
                result[lessPos++] = num;
            } else if (num == pivot) {
                result[equalPos++] = num;
            } else {
                if (greaterPos < n) {
                    result[greaterPos++] = num;
                }
            }
        }
        
        return result;
    }
}