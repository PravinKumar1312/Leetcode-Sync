class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int i = 0;
        int n = colors.length();
        
        while (i < n) {
            int j = i;
            int currentSum = 0;
            int currentMax = 0;
            
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                currentSum += neededTime[j];
                currentMax = Math.max(currentMax, neededTime[j]);
                j++;
            }
            
            if (j - i > 1) {
                totalTime += currentSum - currentMax;
            }
            
            i = j;
        }
        return totalTime;
    }
}