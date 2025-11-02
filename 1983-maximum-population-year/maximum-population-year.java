class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101]; // 1950 to 2050
        
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            
            // Mark all years this person was alive
            for (int year = birth; year < death; year++) {
                years[year - 1950]++;
            }
        }
        
        int maxPopulation = 0;
        int earliestYear = 1950;
        
        for (int i = 0; i < 101; i++) {
            if (years[i] > maxPopulation) {
                maxPopulation = years[i];
                earliestYear = 1950 + i;
            }
        }
        
        return earliestYear;
    }
}