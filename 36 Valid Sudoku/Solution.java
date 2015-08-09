public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        int n = size /3;
        HashSet<Character> hs1 = new HashSet<Character>();
        HashSet<Character> hs2 = new HashSet<Character>();

        for (int i = 0; i < size; i++) {
            hs1.clear();
            hs2.clear();
            for (int j = 0; j < size; j++) {
                if (board[i][j] != '.') {
                    if (hs1.contains(board[i][j]) == false)
                        hs1.add(board[i][j]);
                    else
                        return false;
                }
                if (board[j][i] != '.') {
                    if (hs2.contains(board[j][i]) == false)
                        hs2.add(board[j][i]);
                    else
                        return false;
                }
            }
        }
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                hs1.clear();
                for (int j = 3*a; j < 3*a+3; j++) {
                    for (int k = 3*b; k < 3*b+3; k++) {
                        if (board[j][k] != '.') {
                            if (hs1.contains(board[j][k]) == false)
                                hs1.add(board[j][k]);
                            else
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
