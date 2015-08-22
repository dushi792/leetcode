// Smart Solution: https://leetcode.com/discuss/25593/short-code-by-c
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuffer res = new StringBuffer();
        while (i > -1 || j > -1 || carry == 1) {
            carry += i > -1 ? Character.getNumericValue(a.charAt(i--)) : 0;
            carry += j > -1 ? Character.getNumericValue(b.charAt(j--)) : 0;
            res.append(carry % 2);
            carry /= 2;
        }
        return res.reverse().toString();
    }
}
