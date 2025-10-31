import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int i = num.length - 1;
        
        // Process both numbers until we've handled all digits
        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            
            // Add digit from num array if available
            if (i >= 0) {
                sum += num[i];
                i--;
            }
            
            // Add digit from k if available
            if (k > 0) {
                sum += k % 10;  // Get last digit of k
                k /= 10;        // Remove last digit from k
            }
            
            // Calculate current digit and carry
            result.add(sum % 10);
            carry = sum / 10;
        }
        
        // Reverse the result since we processed from least to most significant digit
        Collections.reverse(result);
        
        return result;
    }
}