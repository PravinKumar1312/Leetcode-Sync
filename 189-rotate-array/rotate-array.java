class Solution {
    public void rotate(int[] a, int k) {
        int n = a.length;
        k = k%n;
        reverse(a,0,n-1);
        reverse(a,0,k-1);
        reverse(a,k,n-1);
    }

    public static void reverse(int[]a, int start, int end){
        while(start<end){
            int temp = a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
}