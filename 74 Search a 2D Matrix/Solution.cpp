//not accepted code
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = 0;
        int m = matrix.size();
        int n = matrix[0].size();
        
        for (; row < m; row++) {
            if (matrix[row][0] > target) {
                if (row >0)
                    row--;
                break;
            }
            if (matrix[row][0] == target)
                return true;
        }
        
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = (i+j)/2;
            if (target == matrix[row][mid])
                return true;
            if (target > matrix[row][mid])
                i = mid+1;
            else
                j = mid-1;
        }
        return false;
    }
};

//AC CODE
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = 0;
        int m = matrix.size();
        int n = matrix[0].size();
        
        
        int i = 0;
        int j = m * n - 1;
        while (i <= j) {
            int mid = (i+j)/2;
            if (target == matrix[mid/n][mid%n])
                return true;
            if (target > matrix[mid/n][mid%n])
                i = mid+1;
            else
                j = mid-1;
        }
        return false;
    }
};