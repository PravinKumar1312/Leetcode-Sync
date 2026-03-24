class Solution {
    public int[] moveZeroes(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for(int i = 0,x=0; i<n; i++){
            if(a[i]!=0)
                b[x++] = a[i];
        }
        for(int i = 0;i <n;i++){
            a[i] = b[i];
        }
        return a;
    }
}