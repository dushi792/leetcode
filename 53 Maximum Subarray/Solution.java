public class Solution {
    public int maxSubArray(int[] nums) {
        /*只要返回最终值，不用子序列*/
        int currmax = nums[0];
        int summax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currmax = currmax + nums[i] > nums[i] ? currmax + nums[i] : nums[i];
            summax = currmax > summax ? currmax : summax;
        }
        return summax;
    }
}