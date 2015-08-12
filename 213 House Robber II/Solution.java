public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(helper(nums, 0, nums.length-1), helper(nums, 1, nums.length));
    }
    private int helper(int[] nums, int begin, int end) {
        int a = 0;
        int b = 0;
        for (int i = begin; i < end; i++) {
            if (i%2 == 0)
                a = Math.max(b, a + nums[i]);
            else
                b = Math.max(a, b + nums[i]);
        }
        return Math.max(a,b);
    }
}
