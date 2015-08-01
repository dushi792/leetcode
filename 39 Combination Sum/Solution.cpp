class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        sort(candidates.begin(), candidates.end());
        vector<int> vec;
        recurse(candidates, target, 0, vec, res);
        return res;
    }
    void recurse(vector<int>& candidates, int target, int index, vector<int> vec, vector<vector<int>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.push_back(vec);
            return;
        }

        for (int i = index; i < candidates.size(); i++) {
            vec.push_back(candidates[i]);
            recurse(candidates, target - candidates[i], index, vec, res);
            vec.pop_back();
        }
    }
};
