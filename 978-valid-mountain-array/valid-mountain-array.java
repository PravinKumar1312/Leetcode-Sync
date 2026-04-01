class Solution {
    public boolean validMountainArray(int[] a) {
        int n = a.length;
        int i = 0; 
        if(n<3)
            return false;
        while(i+1<n && a[i]<a[i+1]){
            i++;
        }
        if(i == n-1 || i == 0)
            return false;
        while(i+1<n && a[i]>a[i+1])
            i++;
        return i == n-1;
    }
}