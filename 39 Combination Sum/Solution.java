public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        recurse(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    public void recurse(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            recurse(candidates, target-candidates[i], i, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
