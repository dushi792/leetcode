// 弱方法（超时）
public class Solution {
    public int divide(int dividend, int divisor) {
        int res = 0;
        if (divisor == 0) return MAX_INT;
        while (dividend >= divisor) {
            dividend -= Math.abs(divisor);
            res = divisor > 0 ? res++ : res--;
        }
        return res;
    }
}

// 位运算: 每次左移一位相当于乘以2
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean isNegative = (dividend < 0 && divisor > 0) ||
                            (dividend > 0 && divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int res = 0;
        while (dvd >= dvs) {
            int shift = 0;
            while (dvd >= (dvs<<shift)) {
                shift++;
            }
            //res += shift-1;
            res += 1 << (shift - 1);
            dvd -= dvs << (shift - 1);
        }
        return isNegative ? -res : res;
    }
}