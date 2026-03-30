class Solution {
    public int removeDuplicates(int[] a) {
        int n = a.length;
        int i = 0;
        if(n==0)
            return 0;
        for(int j=1;j<n;j++){
            if(a[i]!=a[j]){
                i++;
                a[i]=a[j];
            }
        }
        return i+1;







        
        
        
        
        
        
        
        
        // if (nums.length == 0) return 0;
        // int k = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] != nums[i-1]) {
        //         nums[k] = nums[i];
        //         k++;
        //     }
        // }
        // return k;
    }
}