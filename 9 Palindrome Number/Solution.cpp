class Solution {
public:
    bool isPalindrome(int x) {
		//负数不是回文
        if (x < 0) return false;
        
        int n = 1;
        while (x/n >= 10) {
            n *= 10;
        }

        while (x != 0) {
            int first = x / n;
            int last = x % 10;
            if (first != last)
                return false;
            x = x % n / 10;
            n /= 100;
        }
        return true;
    }
};