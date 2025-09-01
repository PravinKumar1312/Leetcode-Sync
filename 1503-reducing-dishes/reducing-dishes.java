import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int total = 0;
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            total += satisfaction[i];
            if (total < 0) {
                break;
            }
            result += total;
        }
        return result;
    }
}