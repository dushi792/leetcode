// 本题还有DP解法
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new LinkedList<Integer>(), res);
        return res;
    }
    private void backtracking(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<Integer>(curr));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) continue;
            curr.add(candidates[i]);
            backtracking(candidates, target-candidates[i], i+1, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
