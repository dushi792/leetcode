class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        if (numRows == 0)
            return res;
        res.push_back(vector<int>(1,1));
        if (numRows == 1)
            return res;
        res.push_back(vector<int>(2,1));
        if (numRows == 2)
            return res;
        
        for (int i = 3; i <= numRows; i++) {
            vector<int> pre = res.back();
            int size = pre.size();
            vector<int> curr(size+1, 1);
            for (int j = 1; j < size; j++) {
                curr[j] = pre[j-1] + pre[j];
            }
            res.push_back(curr);
        }
        return res;
    }
};

//Shorter and better version
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res(numRows);
        
        for (int i = 0; i < numRows; i++) {
            res[i].resize(i+1);
            res[i][0] = res[i][i] = 1;
            
            for (int j = 1; j < i; j++) {
                res[i][j] = res[i-1][j-1] + res[i-1][j];
            }
        }
        return res;
    }
};