class Solution {
    public int maxSubArray(int[] a) {
        int n = a.length;
        int cs = 0, maximum=a[0];
        for(int i = 0; i<n;i++){
            cs += a[i];
            maximum = Math.max(cs,maximum);
            if(cs<0)
                cs = 0;
        }
        return maximum;

    }
}