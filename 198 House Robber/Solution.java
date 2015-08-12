// Low space complexity
public class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0)
                a = Math.max(b, a + nums[i]);
            else
                b = Math.max(a, b + nums[i]);
        }
        return Math.max(a,b);
    }
}
