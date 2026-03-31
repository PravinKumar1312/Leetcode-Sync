class Solution {
    public long subArrayRanges(int[] a) {
        int n = a.length;
        long sum = 0;
        for(int i = 0; i<n;i++){
            int min = a[i], max=a[i];
            for(int j = i; j<n;j++){
                min=Math.min(a[j],min);
                max=Math.max(a[j],max);
                sum += max-min;
            }
        }
        return sum;
    }
}