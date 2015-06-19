class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> num;
        DFS(num, res, 1, n, k);
        return res;
    }
    
    void DFS (vector<int>& num, vector<vector<int>>& res, int start, int n, int k) {
        if (num.size() == k) {
            res.push_back(num);
            return ;
        }
        for (int i = start; i <= n; i++) {
            num.push_back(i);
            DFS(num, res, i+1, n, k);
            num.pop_back();
        }
    }
};