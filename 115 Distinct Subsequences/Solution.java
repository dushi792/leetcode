// Reference: https://leetcode.com/discuss/26680/easy-to-understand-dp-in-java
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] res = new int[t.length()+1][s.length()+1];

        for (int i = 0; i < s.length()+1; i++) {
            res[0][i] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i))
                    // Why res[i][i] ??
                    res[i+1][j+1] = res[i][j] + res[i+1][j];
                else
                    res[i+1][j+1] = res[i+1][j];
            }
        }
        return res[t.length()][s.length()];
    }
}
