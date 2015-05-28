public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i)){
                int count = map.get(i) + 1;
                map.put(i, count);
            }
            else {
                map.put(i, 1);
            }
        }
        
        for (int item : map.keySet()) {
            if (map.get(item) > nums.length/2)
                return item;
        }
        return -1;
    }
}