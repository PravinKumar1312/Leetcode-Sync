class Solution {
    public boolean check(int[] a) {
        int count = 0;
        int n = a.length;
        for(int i = 1;i<n;i++){
            if(a[i-1]>a[i])
                count++;
        }
        if(a[n-1]>a[0]){
            count++;
        }
        if(count<=1)
            return true;
        return false;
    }
}