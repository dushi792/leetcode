// Recursive && DP :https://leetcode.com/discuss/3632/any-better-solution
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (!Arrays.equals(a,b)) return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) &&
                isScramble(s1.substring(i), s2.substring(0,s2.length()-i)))
                return true;
        }
        return false;
    }
}
