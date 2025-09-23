class Solution {
    public int subtractProductAndSum(int n) {

        int product = 1;
        int sum = 0;
        int num = Math.abs(n);

        while (num > 0) {
            int temp = num % 10;
            product *= temp;
            sum += temp;
            num /= 10;
        }

        int ans = product - sum;
        return ans;
    }
}