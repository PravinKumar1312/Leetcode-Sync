class Solution {
    public int majorityElement(int[] a) {
        int n = a.length;
        int max = 0;
        for(int i = 0; i<n;i++){
            int count = 0;
            for(int j = i;j<n;j++){
                if(a[i]==a[j])
                    count++;
            }

            max=Math.max(count,max);
            if(max>n/2)
                return a[i];
        }
        return max;
    }
}