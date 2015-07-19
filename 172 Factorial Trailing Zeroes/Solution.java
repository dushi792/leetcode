public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        for (;n >= 5; n /= 5)
            result += n / 5;
        return result;
    }
}