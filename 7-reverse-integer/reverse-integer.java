class Solution {
    public int reverse(int x) {
        int ans = 0;
        
        while (x != 0) {
            int m = x % 10;
            x /= 10;
            
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && m > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && m < -8)) {
                return 0;
            }
            
            ans = ans * 10 + m;
        }
        
        return ans;
    }
}