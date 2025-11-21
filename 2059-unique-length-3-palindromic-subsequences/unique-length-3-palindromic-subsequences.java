class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }
        
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1 || first[i] == last[i]) {
                continue;
            }
            boolean[] seen = new boolean[26];
            int count = 0;
            for (int j = first[i] + 1; j < last[i]; j++) {
                int midChar = s.charAt(j) - 'a';
                if (!seen[midChar]) {
                    seen[midChar] = true;
                    count++;
                }
            }
            result += count;
        }
        return result;
    }
}