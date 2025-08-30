class Solution {
    public String largestNumber(int[] nums) {
        String[] asStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrings[i] = String.valueOf(nums[i]);
        }
        
        // Sort the array of strings with a custom comparator
        Arrays.sort(asStrings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        
        // If the largest number is "0", return "0"
        if (asStrings[0].equals("0")) {
            return "0";
        }
        
        // Build the result string
        StringBuilder result = new StringBuilder();
        for (String numStr : asStrings) {
            result.append(numStr);
        }
        
        return result.toString();
    }
}