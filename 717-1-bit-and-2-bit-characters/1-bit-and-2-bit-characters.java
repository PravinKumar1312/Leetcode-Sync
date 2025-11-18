class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;
        
        // Traverse through all bits except the last one
        while (i < n - 1) {
            if (bits[i] == 1) {
                // Skip the next bit (it's part of a two-bit character)
                i += 2;
            } else {
                // Move to next bit (it's a one-bit character)
                i += 1;
            }
        }
        
        // If we ended exactly at the last position, the last character is one-bit
        return i == n - 1;
    }
}