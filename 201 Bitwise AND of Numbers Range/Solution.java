// Reference:http://www.cnblogs.com/grandyang/p/4431646.html
//直接平移m和n，每次向右移一位，直到m和n相等，记录下所有平移的次数i，然后再把m左移i位即为最终结果
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int moveFactor = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor++;
        }
        return m << moveFactor;
    }
}
