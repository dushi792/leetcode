public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            if (set.add(s.charAt(end))) {
                if (res < end - start + 1) {
                    res = end - start + 1;
                }
                end++;
            }
            else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return res;
    }
}