class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> permutation;
        if (nums.size() == 0)
            return permutation;
            
        vector<bool> isVisited(nums.size(), false);
        vector<int> curr;
        backTracking(permutation, isVisited, curr, nums);
        return permutation;
    }
    void backTracking(vector<vector<int>>& per, vector<bool> isVisited, vector<int> curr, vector<int> nums) {
        if (nums.size() == curr.size()) {
            per.push_back(curr);
            return;
        }
        for (int i = 0; i < nums.size(); i++){
            if (isVisited[i] == false) {
                isVisited[i] = true;
                curr.push_back(nums[i]);
                backTracking(per, isVisited, curr, nums);
                curr.pop_back();
                isVisited[i] = false;
            }
        }
    }
};