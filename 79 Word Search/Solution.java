public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = find(board, word, 0, i, j);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean find(char[][] board, String word, int index, int i, int j) {
        if (index >= word.length()){
            return true;
        }
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        board[i][j] = '#';
        boolean res = find(board, word, index + 1, i, j + 1) || find(board, word, index + 1, i, j - 1) ||
                            find(board, word, index + 1, i + 1, j) || find(board, word, index + 1, i - 1, j);
        board[i][j] = word.charAt(index);
        
        return res;
    }
}