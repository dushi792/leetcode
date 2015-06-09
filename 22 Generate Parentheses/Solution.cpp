class Solution {
public:
    vector<string> res;
    
    vector<string> generateParenthesis(int n) {
        if (n <= 0)
            return res;
        help(n, n, "");
        return res;
    }
    
    void help(int l, int r, string s) {
        if (r < l)
            return;
        if (l == 0 && r == 0) {
            res.push_back(s);
        }
        if (l > 0)
            help(l-1, r, s+"(");
        if (r > 0)
            help(l, r-1, s+")");
    }
};