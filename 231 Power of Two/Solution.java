public class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean flag = false;
        while (n > 0) {
            if ((n&1) == 1) {
                if (flag)
                    return false;
                flag = true;
            }
            n >>>= 1;
        }
        return flag;
    }
}

// Better answer:
// Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1)) == 0;
    }
}
