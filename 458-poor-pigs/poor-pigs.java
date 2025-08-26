class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int T = minutesToTest / minutesToDie;
        int base = T + 1;
        // We need to find the smallest x such that base^x >= buckets
        int x = 0;
        long total = 1; // to avoid integer overflow, use long
        while (total < buckets) {
            total *= base;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buckets = sc.nextInt();
        int minutesToDie = sc.nextInt();
        int minutesToTest = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.poorPigs(buckets, minutesToDie, minutesToTest));
        sc.close();
    }
}