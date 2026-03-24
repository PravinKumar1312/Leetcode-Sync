class Solution {
    public int maxArea(int[] a) {
        int s=0, n=a.length-1;
        int max_area = 0;

        while(s<n){
            int l = Math.min(a[s],a[n]);
            int b = n-s;
            int area = l * b;
            max_area = Math.max(area,max_area);
            if(a[s]<a[n])
                s++;
            else
                n--;
        }
        return max_area;
    }
}