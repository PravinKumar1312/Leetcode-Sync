class Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = getScore(root, words[i]);
        }
        return ans;
    }
    
    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            node.count++;
        }
    }
    
    private int getScore(TrieNode root, String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            node = node.children[idx];
            score += node.count;
        }
        return score;
    }
    
    class TrieNode {
        TrieNode[] children;
        int count;
        
        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }
}