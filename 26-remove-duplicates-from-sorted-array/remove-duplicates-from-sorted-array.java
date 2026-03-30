class Solution {
    public int removeDuplicates(int[] a) {
        
        int i = 1;
        if(a.length==0)
            return 0;
        for(int j=1;j<a.length;j++){
            if(a[j]!=a[j-1]){
                a[i]=a[j];
                i++;

            }
        }
        return i;
        
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