class Solution {
    public static int addDigits(int a) {
        while(a>=10){
            int sum = 0;
            while(a>0){
                sum += a%10;
                a/=10;
            }
            a = sum;
        }
        return a;
    }
}