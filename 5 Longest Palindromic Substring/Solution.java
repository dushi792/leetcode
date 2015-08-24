public class Solution {
    private int index = 0;
    private int len = 1;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return s.substring(index, index+len);
    }
    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > len) {
                len = right - left + 1;
                index = left;
            }
            left--;
            right++;
        }
    }
}