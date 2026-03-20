class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for(int i = 5; i <= n; i*=5){
            count += n/i;
            
            if(n/i <= 0){
                break;
            }
        }
        
        return count;
    }
}