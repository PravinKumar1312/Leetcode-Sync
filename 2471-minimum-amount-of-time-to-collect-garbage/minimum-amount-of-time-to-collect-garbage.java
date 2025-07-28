class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int total = 0;
        int n = garbage.length;

        int[] pref = new int[n];;
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + travel[i - 1];
        }

        int lastM = 0, lastP= 0, lastG = 0;
        for (int i = 0; i < n; i++) {
            String s = garbage[i];

            for (char c : s.toCharArray()) {
                total++;
                if (c == 'M') lastM = i;
                if (c == 'P') lastP = i;
                if (c == 'G') lastG = i;
            }
        }

        total += pref[lastM];
        total += pref[lastP];
        total += pref[lastG];

        return total;
    }
}