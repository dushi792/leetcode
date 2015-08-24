public class Solution {
    public int reverse(int x) {
        int res = 0;
        
        while (x != 0) {
            int tail = x % 10;
            int newRes = res * 10 + tail;
			// 如果没有溢出那么newRes应该可以转换回原来的res, 不能则说明溢出
            if ((newRes-tail) / 10 != res) {
                return 0;
            }
            res = newRes;
			// if x < 0 会自动在最后一轮把结果转换成负数
            x /= 10;
        }
        
        return res;
    }
}