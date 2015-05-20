public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        for (; i < s.length() -1; i++) {
            if (rToI(s.charAt(i)) < rToI(s.charAt(i+1)))
                sum -= rToI(s.charAt(i));
            else
                sum += rToI(s.charAt(i));
        }
        return sum += rToI(s.charAt(i));
    }
    public int rToI(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}