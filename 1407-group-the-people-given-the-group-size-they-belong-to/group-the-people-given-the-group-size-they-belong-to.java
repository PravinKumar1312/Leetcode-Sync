import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> sizeToPeople = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            sizeToPeople.putIfAbsent(size, new ArrayList<>());
            sizeToPeople.get(size).add(i);
        }
        
        for (int size : sizeToPeople.keySet()) {
            List<Integer> people = sizeToPeople.get(size);
            for (int i = 0; i < people.size(); i += size) {
                List<Integer> group = new ArrayList<>();
                for (int j = i; j < i + size; j++) {
                    group.add(people.get(j));
                }
                result.add(group);
            }
        }
        return result;
    }
}