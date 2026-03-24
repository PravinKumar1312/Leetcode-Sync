class Solution {
    public int missingNumber(int[] a) {
        int n = a.length;
        int total_sum = n*(n+1)/2;
        for(int i = 0; i<n; i++){
            total_sum -= a[i];
        }
        return total_sum;
    }
}