class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int res = 0;
        int index = piles.length - 2;
        for (int i = 0; i < n; i++) {
            res += piles[index];
            index -= 2;
        }
        return res;
    }
}