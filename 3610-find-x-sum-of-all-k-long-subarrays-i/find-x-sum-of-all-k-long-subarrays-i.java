class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            result[i] = calculateXSumForWindow(nums, i, k, x);
        }
        
        return result;
    }
    
    private int calculateXSumForWindow(int[] nums, int start, int k, int x) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = start; i < start + k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        if (freqMap.size() <= x) {
            int sum = 0;
            for (int i = start; i < start + k; i++) {
                sum += nums[i];
            }
            return sum;
        }
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        
        Collections.sort(entries, (a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        });
        
        int sum = 0;
        for (int i = 0; i < x; i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            sum += entry.getKey() * entry.getValue();
        }
        
        return sum;
    }
}