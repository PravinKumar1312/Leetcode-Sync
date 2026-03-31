class Solution {
    public int trap(int[] b) {
        int n = b.length;
        if(n==1 || n ==2)
            return 0;
        int[] left_max = new int[n];
        left_max[0] = b[0];
        for(int i = 1; i<n;i++){
            left_max[i]=Math.max(b[i],left_max[i-1]);
        }

        int[] right_max=new int[n];
        right_max[n-1]=b[n-1];
        for(int i = n-2; i>=0;i--){
            right_max[i] = Math.max(b[i],right_max[i+1]);
        }
        
        int sum = 0;
        for(int i = 0; i<n;i++){
            int WL=Math.min(left_max[i],right_max[i]);
            sum += WL-b[i];
        }
        return sum;
    }
}