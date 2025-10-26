import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people: first by height descending, then by k ascending
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // taller first
            } else {
                return a[1] - b[1]; // smaller k first for same height
            }
        });
        
        List<int[]> result = new ArrayList<>();
        
        // Insert each person at position = their k value
        for (int[] person : people) {
            result.add(person[1], person);
        }
        
        // Convert list back to array
        return result.toArray(new int[people.length][]);
    }
}