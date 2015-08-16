// Reference：http://blog.csdn.net/linhuanmars/article/details/20667175
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<List<String>>();
        backtracking(n, res, new int[n], 0);
        return res;
    }
    private void backtracking(int n, List<List<String>> res, int[] quePos, int row) {
        if (row == n) {
            List<String> result = new LinkedList<String>();
            for (int i = 0; i < n; i++) {
                StringBuffer strRow = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (j == quePos[i])
                        strRow.append('Q');
                    else
                        strRow.append('.');
                }
                result.add(strRow.toString());
            }
            res.add(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            quePos[row] = i;
            if (check(quePos, row))
                backtracking(n, res, quePos, row+1);
        }
    }
    private boolean check(int[] quePos, int row) {
        for (int i = 0; i < row; i++) {
            if (quePos[row] == quePos[i] || Math.abs(quePos[row] - quePos[i]) == row-i)
                return false;
        }
        return true;
    }
}
