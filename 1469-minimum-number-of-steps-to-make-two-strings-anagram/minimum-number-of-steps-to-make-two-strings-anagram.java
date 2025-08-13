import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        
        // Count frequencies in s
        for (char c : s.toCharArray()) {
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }
        
        // Count frequencies in t
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        int steps = 0;
        
        // Calculate the difference for each character in s
        for (Map.Entry<Character, Integer> entry : sCount.entrySet()) {
            char key = entry.getKey();
            int sFreq = entry.getValue();
            int tFreq = tCount.getOrDefault(key, 0);
            if (sFreq > tFreq) {
                steps += sFreq - tFreq;
            }
        }
        
        return steps;
    }
}