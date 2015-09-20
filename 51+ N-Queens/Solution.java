// Optimized:
class Solution {
    private ArrayList<String> drawChessBoard(ArrayList<Integer> cols) {
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < cols.size(); i++) {
            String row = new String();
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    row += "Q";
                }
                else {
                    row += ".";
                }
            }
            result.add(row);
        }
        return result;
    }

    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (i - cols.get(i) == row - col) {
                return false;
            }
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }

    private void helper(int n, ArrayList<Integer> cols, ArrayList<ArrayList<String>> res) {
        if (cols.size() == n) {
            res.add(drawChessBoard(cols));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }
            cols.add(i);
            helper(n, cols, res);
            cols.remove(cols.size() - 1);
        }

    }

    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();

        if (n <= 0) {
            return res;
        }

        helper(n, new ArrayList<Integer>(), res);

        return res;
    }
};


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
