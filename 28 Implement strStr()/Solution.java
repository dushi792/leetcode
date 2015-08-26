// brute force
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }
        int res = -1;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; i + j < haystack.length() && j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (res == -1 && j == needle.length() - 1) {
                    res = i;
                }
            }
        }
        return res;
    }
}