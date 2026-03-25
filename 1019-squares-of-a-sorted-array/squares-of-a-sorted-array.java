class Solution {
    public int[] sortedSquares(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        int left = 0, right = n-1, i = n-1;
        while(left<=right){
            int ans1 = a[left]*a[left];
            int ans2 = a[right]*a[right];
            if(ans1>ans2){
                res[i] = ans1;
                left++;
            }
            else{
                res[i] = ans2;
                right--;
            }
            i--;
        }
        return res;
    }
}