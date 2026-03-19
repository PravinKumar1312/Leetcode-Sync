class Solution {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int start = 0;
        int end = x;
        int ans = 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            long y = (long) mid*mid;
            if(y == x)
                return mid;
            else if(y <= x){
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
}