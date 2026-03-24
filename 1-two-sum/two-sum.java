class Solution {
    public int[] twoSum(int[] a, int target) {
        int n = a.length;
        int[] res = new int[2];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j <n; j++){
                if(a[i]+a[j]==target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}