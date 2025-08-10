// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
    
        Map<Integer, List<Integer>> diagonals = new HashMap<>();
        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagonals.putIfAbsent(key, new ArrayList<>());
                diagonals.get(key).add(mat[i][j]);
            }
        }
        

        for (int key : diagonals.keySet()) {
            Collections.sort(diagonals.get(key));
        }
        
        Map<Integer, Integer> indices = new HashMap<>();
        for (int key : diagonals.keySet()) {
            indices.put(key, 0);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> diagonal = diagonals.get(key);
                int index = indices.get(key);
                mat[i][j] = diagonal.get(index);
                indices.put(key, index + 1);
            }
        }
        
        return mat;
    }
}