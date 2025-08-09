class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        int numSubstrings = n / k;
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < numSubstrings; i++) {
            String substring = s.substring(i * k, (i + 1) * k);
            int sum = 0;
            for (char c : substring.toCharArray()) {
                sum += c - 'a';
            }
            int hashedChar = sum % 26;
            result.append((char) (hashedChar + 'a'));
        }
        
        return result.toString();
    }
}