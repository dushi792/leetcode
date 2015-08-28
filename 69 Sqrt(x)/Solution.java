public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int left = 1;
        int right = x;
        
        while (left < right) {
            int mid = (left + right) / 2;
			// 如果写成mid * mid < x, 会overflow,还会导致超时
            if (mid < x / mid) {
                if ((mid+1) > x / (mid+1)) {
                    return mid;
                }
                left = mid + 1;
            }
            else if (mid > x / mid) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return left;
    }
}