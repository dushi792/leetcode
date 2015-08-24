public class Solution {
    public int myAtoi(String str) {
        int res = 0;
        int i = 0;
        int sign = 1;
        if (str == null || str.length() == 0) return res;
        // 跳过空格
        while (str.charAt(i) == ' ') {
            i++;
        }
        // 判断符号
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        // 读数字
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
			// 重要：判断溢出
			// 相当于判断if (res*10 > INT_MAX || 当前数字 > INT_MAX最后一位)
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && 
                str.charAt(i) - '0' > Integer.MAX_VALUE % 10) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }        
        return res*sign;
    }
}