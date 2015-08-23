// 巧妙的运用了HashMap
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i+1;
                res[0] = map.get(target-nums[i])+1;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}