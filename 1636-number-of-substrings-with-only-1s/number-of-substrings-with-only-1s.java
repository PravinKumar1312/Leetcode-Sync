class Solution {
    public int numSub(String s) {
        long count = 0;
        long currentLength = 0;
        int mod = 1000000007;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                currentLength++;
            } else {
                // When we encounter '0', calculate substrings for the previous segment
                count = (count + (currentLength * (currentLength + 1)) / 2) % mod;
                currentLength = 0;
            }
        }
        
        // Don't forget the last segment
        count = (count + (currentLength * (currentLength + 1)) / 2) % mod;
        
        return (int) count;
    }
}