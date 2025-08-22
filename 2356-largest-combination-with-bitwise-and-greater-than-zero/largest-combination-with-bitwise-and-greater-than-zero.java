class Solution {
    public int largestCombination(int[] candidates) {
        int maxCount = 0;
        for (int i = 0; i < 24; i++) {
            int count = 0;
            int mask = 1 << i;
            for (int num : candidates) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}