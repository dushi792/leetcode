// 超时
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String str = null;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int left, right;
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                left = i;
                right = i+1;
            }
            else {
                left = right = i;
            }
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            if (right - left + 1 > len) {
                len = right - left + 1;
                str = s.substring(left+1, right);
            }
        }
        return str;
    }
}