import java.util.*;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];
            int[] subarray = Arrays.copyOfRange(nums, left, right + 1);
            result.add(canBeArithmetic(subarray));
        }
        return result;
    }
    
    private boolean canBeArithmetic(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}