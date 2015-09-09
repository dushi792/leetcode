public class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (isPalindrome(s, i, i + 1)) {
                isPalindrome[i][i + 1] = true;
                isPalindrome[i + 1][i] = true;
            }
        }
        
        for (int i = 2; i < s.length(); i++) {
            for (int start = 0; start + i < s.length(); start++) {
                isPalindrome[start][start + i] = isPalindrome[start + 1][start + i - 1] && s.charAt(start) == s.charAt(start + i);
            }
        }
        
        return isPalindrome;
    }
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        int[] cut = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            cut[i] = i - 1;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 错误：if (isPalindrome[j + 1][i]) {
                // 两个坐标应该都减去 1
                if (isPalindrome[j][i - 1]) {
                    cut[i] = Math.min(cut[i], cut[j] + 1);
                }
            }
        }
        
        return cut[s.length()];
    }
}