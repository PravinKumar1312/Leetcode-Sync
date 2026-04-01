class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = (m+n)-1;
        int i = m-1, j = n-1;
        while(i>=0 && j >=0){
            if(nums1[i]>nums2[j]){
                nums1[x] = nums1[i];
                x--;
                i--;
            }
            else{
                nums1[x]=nums2[j];
                j--;
                x--;
            }
        }
        while(i>=0){
            nums1[x]=nums1[i];
            x--;
            i--;
        }
        while(j>=0){
            nums1[x]=nums2[j];
            x--;
            j--;
        }
    }
}