// 在Lintcode下会超时
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (canBreak[j] == false) {
                    continue;
                }
                String word = s.substring(j, i);
                if (wordDict.contains(word)) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}



// Lintcode AC:
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(word.length(), maxLength);
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 && dict.size() != 0) {
            return false;
        }
        if (s.length() == 0 && dict.size() == 0) {
            return true;
        }

        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        int maxLength = getMaxLength(dict);

        for (int i = 1; i <= s.length(); i++) {
            for (int lastWordLen = 1; lastWordLen <= maxLength && lastWordLen <= i; lastWordLen++) {
                if (canBreak[i - lastWordLen] == false) {
                    continue;
                }
                String word = s.substring(i - lastWordLen, i);
                if (dict.contains(word)) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
