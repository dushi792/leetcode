public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                product[i + j + 1] += a * b;
            }
        }
        int carry = 0;
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            int temp = carry;
            carry = (product[i] + carry) / 10;
            product[i] = (temp + product[i]) % 10;
        }
        StringBuffer sb = new StringBuffer();
        for (int n : product) {
            sb.append(n);
        }
		// 注意判断开头多个零的情况
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}