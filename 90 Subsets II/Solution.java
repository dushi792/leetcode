public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        if (nums.length == 0)
            return result;
        Arrays.sort(nums);
        result.add(new LinkedList<Integer>());
        backTracking(result, temp, nums, 0);
        return result;
    }
    public void backTracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        if (index == nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            result.add(new LinkedList(temp));
            backTracking(result, temp, nums, i+1);
            temp.remove(temp.get(temp.size()-1));
            // 如果发现有相等的，只遍历一个，后续跳过
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}