public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(nums, res, new LinkedList<Integer>(), new boolean[nums.length]);
        return res;
    }
    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> curr ,boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<Integer>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 关键条件：visited[i-1] == false， 说明相同数字的遍历已经完成，碰到直接跳过
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1] == false) continue;
            if (visited[i] == false) {
                visited[i] = true;
                curr.add(nums[i]);
                backtracking(nums, res, curr, visited);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}
