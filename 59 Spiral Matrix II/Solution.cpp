class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n, vector<int>(n,0));
        int i = 0;
        int j = 0;
        int k = 1;
        int cases = 0;
        while (k <= n*n) {
            res[i][j] = k++;
            switch (cases) {
                case 0: {
                    j++;
                    if (j == n||res[i][j] != 0) {
                        cases = 1;
                        j--;
                        i++;
                    }
                    break;
                }
                case 1: {
                    i++;
                    if (i==n||res[i][j] != 0) {
                        cases = 2;
                        i--;
                        j--;
                    }
                    break;
                }
                case 2: {
                    j--;
                    if (j == -1||res[i][j] != 0) {
                        cases = 3;
                        j++;
                        i--;
                    }
                    break;
                }
                case 3: {
                    i--;
                    if (j == -1||res[i][j] != 0) {
                        cases = 0;
                        i++;
                        j++;
                    }
                    break;
                }
            }
        }
        return res;
    }
};