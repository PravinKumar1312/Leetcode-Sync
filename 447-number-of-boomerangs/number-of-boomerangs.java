class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) return 0;
        
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            // Map to store distance -> count of points at that distance from i
            Map<Integer, Integer> distanceCount = new HashMap<>();
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int distance = dx * dx + dy * dy; // Use squared distance to avoid floating point
                
                distanceCount.put(distance, distanceCount.getOrDefault(distance, 0) + 1);
            }
            
            // For each distance group, if there are k points at that distance,
            // we can form k * (k - 1) boomerangs
            for (int count : distanceCount.values()) {
                if (count >= 2) {
                    result += count * (count - 1);
                }
            }
        }
        
        return result;
    }
}