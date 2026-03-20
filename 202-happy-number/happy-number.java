class Solution {
    public boolean isHappy(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 1 && num != 4 && num != 0) {
            int sum = 0;
            while(num > 0) {
                sum += (num%10)*(num%10);
                num /= 10;
            }
            num = sum;
        }
        if (num == 1) {
                return true;
        }
        else if (num == 4) {
            return false;
        }
        else{
            return false;
        }
    }
}