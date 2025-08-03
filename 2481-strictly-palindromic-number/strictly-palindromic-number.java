class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int b = 2; b <= n - 2; b++) {
            String s = convertToBase(n, b);
            if (!isPalindrome(s)){
                return false;
            }
        }
        return true;
    }
    private String convertToBase(int n, int base) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % base);
            n /= base;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}