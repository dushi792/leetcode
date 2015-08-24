public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;
        
        char[] c = s.toCharArray();
        StringBuffer[] res = new StringBuffer[numRows];
		// 要注意分配内存地址
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuffer();
        }
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; i < s.length() && j < numRows; j++) {
                res[j].append(c[i++]);
            }
            for (int j = numRows - 2; i < s.length() && j > 0; j--) {
                res[j].append(c[i++]);
            }
        }
        for (i = 1; i < res.length; i++) {
            res[0].append(res[i]);
        }
        return res[0].toString();
    }
}

// My original version
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return s;        
        char[] c = s.toCharArray();
        StringBuffer[] res = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuffer();
        }
        int i = 0;
        while (i < s.length()) {
            int j = 0;
            while (i < s.length() && j < numRows) {
                res[j++].append(c[i++]);
            }
            j = numRows - 2;
            while (i < s.length() && j > 0) {
                res[j--].append(c[i++]);
            }
        }
        for (i = 1; i < res.length; i++) {
            res[0].append(res[i]);
        }
        return res[0].toString();
    }
}